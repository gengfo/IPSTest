package com.gengfo.performance;

import java.io.IOException;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public class Tms2PerformanceTest extends PerformanceTest {

    private String templateTMS2JO;

    // private String templateTMS2DO;
    //
    // private String templateTMS2INTJO;

    private String templateTMS2AUTOREF;

    public Tms2PerformanceTest(int count) {
        super(count);
        
        
        System.out.println("in Tms2PerformanceTest, count " + count);
        
        this.resultFileName = "C:/tms2_stesstest_result.txt";
        try {
            msgConsumer = jmsSession.createConsumer(jmsSession.createQueue("RS.IPS.SEND.ARAPACK_TMS"));
            msgProducer = jmsSession.createProducer(jmsSession.createQueue("RS.IPS.RCV.ARAP_TMS"));
            templateTMS2JO = getTemplate("com/oocl/ips/tms2_jobcost_jo.xml");
            // templateTMS2DO = getTemplate("com/oocl/ips/tms2_jobcost_do.xml");
            // templateTMS2INTJO = getTemplate("com/oocl/ips/tms2_jobcost_intercomjo.xml");
            templateTMS2AUTOREF = getTemplate("com/oocl/ips/autoim_ref.xml");
        } catch (JMSException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void sendMessages() throws Exception {
        float j = 0;
        for (float i = 0; i < count; i++) {
            if (j < i) {
                sendMsg(templateTMS2JO, getJoNumber("TMS2JO", (int) i));
                j += 1.78;
            }
            sendMsg(templateTMS2AUTOREF, getJoNumber("TMS2DREF", (int) i));
            Thread.sleep(2880);
        }
    }

    private void sendMsg(String temp, String joNumber) throws Exception {
        TextMessage msg = jmsSession.createTextMessage();
        msg.setText(temp.replaceAll("JO_NUMBER", joNumber));
        msg.setJMSTimestamp(System.currentTimeMillis());
        msg.setStringProperty("IR2NP_AppNamespace", "ips");
        msg.setStringProperty("IR2NP_MessageType", "JobOrder");
        msg.setJMSCorrelationID(joNumber);
        msgProducer.send(msg);
        sendMsgTimeMap.put(joNumber, new Date().getTime());
        System.out.println("Send JO: " + joNumber);
    }

}
