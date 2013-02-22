package com.gengfo.msg;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class EmsHelper {

    public static void sendMsg(Session jmsSession, MessageProducer msgProducer, String template, String joNumber) {
        StringBuilder msgTextSb = new StringBuilder();
        msgTextSb.append(template.replaceAll("JO_NUMBER", joNumber));
        TextMessage msg;
        try {
            msg = jmsSession.createTextMessage();

            msg.setText(msgTextSb.toString());
            msg.setJMSTimestamp(System.currentTimeMillis());
            msg.setStringProperty("IR2NP_AppNamespace", "ips");
            msg.setStringProperty("IR2NP_MessageType", "JobOrder");
            msg.setJMSCorrelationID(joNumber);
            msgProducer.send(msg);
            // sendMsgTimeMap.put(joNumber, new Date().getTime());
            // System.out.println("Send JO: " + joNumber);

        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
