package com.gengfo.performance;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public class BillRptPerformanceTest extends PerformanceTest {

    private String templateBillRpt;

    public BillRptPerformanceTest(int count) {
        
        super(count);
        
        System.out.println("in Tms2PerformanceTest, count " + count);
        
        this.resultFileName = "C:/billrpt_stesstest_result.txt";
        try {
            // msgConsumer = jmsSession.createConsumer(jmsSession.createTopic("RS.IPS.RESPONSE.ACK.TPC"));
            msgProducer = jmsSession.createProducer(jmsSession.createQueue("RS.IPS.RCV.APBILLRPT_TMS"));

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void sendMessages() throws Exception {
        int fileIndex = 0;
        for (int i = 0; i < count; i++) {
            fileIndex = i % 9;
            templateBillRpt = getTemplate("com/oocl/ips/billrpts/bill_report" + fileIndex + ".xml");
            sendMsg(templateBillRpt, "billreport" + (int) i);
            Thread.sleep(960000);
        }

    }

    @Override
    public void test() throws Exception {
        sendMessages();
    }

    private void sendMsg(String template, String joNumber) throws Exception {
        StringBuilder msgTextSb = new StringBuilder();
        msgTextSb.append(template);
        TextMessage msg = jmsSession.createTextMessage();
        msg.setText(msgTextSb.toString());
        msg.setJMSTimestamp(System.currentTimeMillis());
        msg.setStringProperty("IR2NP_AppNamespace", "ips");
        msg.setStringProperty("IR2NP_MessageType", "JobOrder");
        msg.setJMSCorrelationID(joNumber);
        msgProducer.send(msg);
        System.out.println("Send JO: " + joNumber);
    }

}
