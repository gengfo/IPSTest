package com.gengfo.performance;

import java.io.IOException;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public class IcsDscPerformanceTest extends PerformanceTest {

    private String templateDCS;

    private String templateICS;

    public IcsDscPerformanceTest(int count) {
        
        
        super(count);
        System.out.println("in IcsDscPerformanceTest, count " + count);
        this.resultFileName = "C:/icsdcs_stesstest_result.txt";
        try {
            msgConsumer = jmsSession.createConsumer(jmsSession.createTopic("RS.IPS.RESPONSE.ACK.TPC"));
            msgProducer = jmsSession.createProducer(jmsSession.createQueue("RS.IPS.RCV.JOBCOST"));
            templateDCS = getTemplate("com/oocl/ips/dcs_jobcost.xml");
            templateICS = getTemplate("com/oocl/ips/ics_jobcost.xml");
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
            sendMsg(templateDCS, getJoNumber("DCSJO", (int) i));
            if (j < i) {
                sendMsg(templateICS, getJoNumber("ICSJO", (int) i));
                j += 2.86;
            }
            Thread.sleep(14400);
        }

    }

    private void sendMsg(String template, String joNumber) throws Exception {
        StringBuilder msgTextSb = new StringBuilder();
        msgTextSb.append(template.replaceAll("JO_NUMBER", joNumber));
        TextMessage msg = jmsSession.createTextMessage();
        msg.setText(msgTextSb.toString());
        msg.setJMSTimestamp(System.currentTimeMillis());
        msg.setStringProperty("IR2NP_AppNamespace", "ips");
        msg.setStringProperty("IR2NP_MessageType", "JobOrder");
        msg.setJMSCorrelationID(joNumber);
        msgProducer.send(msg);
        sendMsgTimeMap.put(joNumber, new Date().getTime());
        System.out.println("Send JO: " + joNumber);
    }

}
