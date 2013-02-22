package com.gengfo.simple.jobcost.icsdcs;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import com.gengfo.msg.DataHelper;
import com.gengfo.msg.EmsHelper;

public class SendJobCostMsg {

    public static void main(String args[]) throws JMSException {

        String url = "tcp://shasun3:7223";
        String user = "ivoadmin";
        String password = "ivoadmin";
        ConnectionFactory factory = new com.tibco.tibjms.TibjmsConnectionFactory(url);
        Connection jmsConnection = factory.createConnection(user, password);
        Session jmsSession = jmsConnection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
        //MessageProducer msgProducer = jmsSession.createProducer(jmsSession.createQueue("RS.IPS.RCV.JOBCOST"));
        MessageProducer msgProducer = jmsSession.createProducer(jmsSession.createQueue("RS.IPS.TEST.MSG.QUEUE"));
        

        String template = DataHelper.getTemplate("com/oocl/ips/dcs_jobcost.xml");
        String joNumber = DataHelper.getJoNumber("DCSJO", (int) System.currentTimeMillis());

        EmsHelper.sendMsg(jmsSession, msgProducer, template, joNumber);

        System.out.println("Done");

    }

}
