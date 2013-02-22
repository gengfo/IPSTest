package com.gengfo.performance;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PerformanceTest {

    // need to sort the keys
    protected final Map<String, Long> sendMsgTimeMap = new TreeMap<String, Long>();

    private final Map<String, Long> receiveMsgTimeMap = new HashMap<String, Long>();

    private Connection jmsConnection;

    protected Session jmsSession;

    protected MessageConsumer msgConsumer;

    protected MessageProducer msgProducer;

    protected int count;

    protected String resultFileName;

    public PerformanceTest(int count) {
        this.count = count;
        ConnectionFactory factory = new com.tibco.tibjms.TibjmsConnectionFactory("tcp://shasun3:7223");
        try {
            jmsConnection = factory.createConnection("ivoadmin", "ivoadmin");
            jmsSession = this.jmsConnection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    public void test() throws Exception {
        java.sql.Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            this.jmsConnection.start();
            this.setListener();
            sendMessages();

            while (true) {
                if (sendMsgTimeMap.size() == receiveMsgTimeMap.size()) {
                    break;
                }
                Thread.sleep(1000L);
            }

            msgConsumer.setMessageListener(null);
            jmsConnection.close();

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@shalxdv3:1521:ivodb", "ivo_aeuser", "ivoaeuser");
            stmt = conn
                    .prepareStatement("select t.msg_date from file_transfer_log t where t.ref_num = ? order by t.msg_date desc");

            Collection<String> list = new ArrayList<String>(11000);

            for (Map.Entry<String, Long> entry : this.sendMsgTimeMap.entrySet()) {
                String joNo = entry.getKey();
                stmt.setString(1, joNo);
                rs = stmt.executeQuery();
                long ackTime = 0;
                if (rs.next()) {
                    ackTime = rs.getTimestamp(1).getTime();
                }
                long joTime = 0;
                if (rs.next()) {
                    joTime = rs.getTimestamp(1).getTime();
                }
                list.add(joNo + " " + sendMsgTimeMap.get(joNo) + " " + joTime + " " + ackTime + " "
                        + receiveMsgTimeMap.get(joNo));
            }
            FileUtils.writeLines(new File(resultFileName), list);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    private void setListener() throws Exception {
        msgConsumer.setMessageListener(new MessageListener() {

            public void onMessage(Message arg0) {
                try {
                    String text = ((TextMessage) arg0).getText();
                    Matcher matcher = Pattern.compile("com:OrderNo>(.+?)</com:OrderNo").matcher(text);
                    if (matcher.find()) {
                        receiveMsgTimeMap.put(matcher.group(1), new Date().getTime());
                        // System.out.println("Receive ACK:" + matcher.group(1));
                    }
                } catch (JMSException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }

    protected abstract void sendMessages() throws Exception;

    public static String getJoNumber(String prefix, int currentCount) {
        DateFormat df = new SimpleDateFormat("yyyyMMDDHHmmss");
        return prefix + (df.format(new Date()) + currentCount);
    }

    protected String getTemplate(String tempRes) throws IOException {
        InputStream stream = ClassLoader.getSystemResourceAsStream(tempRes);
        BufferedReader brInvAdjEntries = new BufferedReader(new InputStreamReader(stream));
        String sqlLine = brInvAdjEntries.readLine();
        StringBuffer sql = new StringBuffer();
        while (sqlLine != null) {
            sql.append(sqlLine);
            sqlLine = brInvAdjEntries.readLine();
        }
        return sql.toString();
    }

    /**
     * @param args
     * @throws Exception
     */
    

    public static void main(String[] args) {
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, Calendar.OCTOBER);
        cal.set(Calendar.DAY_OF_MONTH, 21);
        cal.set(Calendar.HOUR_OF_DAY, 4);
        cal.set(Calendar.MINUTE, 00);
        
        IcsDscPerformanceTest p = new IcsDscPerformanceTest(1000);
        try {
            p.test();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    public static void main1(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, Calendar.OCTOBER);
        cal.set(Calendar.DAY_OF_MONTH, 21);
        cal.set(Calendar.HOUR_OF_DAY, 4);
        cal.set(Calendar.MINUTE, 00);
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                try {
                    new IcsDscPerformanceTest(1000).test();
                } catch (Exception e) { // NOPMD Matthew:ok in main
                    e.printStackTrace(); // NOPMD Matthew:ok in main
                }
            }
        }, cal.getTime());
        
        
        
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                try {
                    new Tms2PerformanceTest(5000).test();
                } catch (Exception e) { // NOPMD Matthew:ok in main
                    e.printStackTrace(); // NOPMD Matthew:ok in main
                }
            }
        }, cal.getTime());
        
        
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                try {
                    new BillRptPerformanceTest(15).test();
                } catch (Exception e) { // NOPMD Matthew:ok in main
                    e.printStackTrace(); // NOPMD Matthew:ok in main
                }
            }
        }, cal.getTime());

    }

    protected Log getLog() {
        return LogFactory.getLog(getClass());
    }

}
