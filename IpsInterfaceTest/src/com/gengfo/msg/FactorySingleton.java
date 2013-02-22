package com.gengfo.msg;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;

public class FactorySingleton {

    private static String url = "tcp://shasun3:7223";

    private static String user = "ivoadmin";

    private static String password = "ivoadmin";

    private static ConnectionFactory factory;

    private static Connection jmsConnection;

    private static Session jmsSession;

    static {
        factory = new com.tibco.tibjms.TibjmsConnectionFactory(url);
        try {
            jmsConnection = factory.createConnection(user, password);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private static FactorySingleton fs = new FactorySingleton();

    public static FactorySingleton getInstance() {
        return fs;
    }

    public synchronized ConnectionFactory getFactory() {
        return factory;
    }

    public synchronized Connection getConnection() {
        return jmsConnection;
    }

    public synchronized Session getSession() {
        try {
            jmsSession = jmsConnection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
        return jmsSession;
    }

}
