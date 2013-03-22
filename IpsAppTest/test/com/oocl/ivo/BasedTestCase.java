package com.oocl.ivo;

import junit.framework.TestCase;

import com.oocl.csc.frm.integration.configuration.loader.FWConfigurationLoader;
import com.oocl.frm.transaction.DataSourceSession;
import com.oocl.frm.transaction.TransactionManager;
import com.oocl.frm.transaction.toplink.UOWDataSource;

public class BasedTestCase extends TestCase {

    public static final String SYS_PRO_CONFIG_FILE = "FRAMEWORK_CONFIG_FILE";

    public static final String FRM_CONFIG_XML = "C:/ips_oc4j_101350/j2ee/home/config/fil_config/config.xml";

    public void setUp() throws Exception {

        // try {
        // FWConfigurationLoader.initConfig(System.getProperty(SYS_PRO_CONFIG_FILE, FRM_CONFIG_XML), "IPSTest",
        // "IPSTest");
        // } catch (Exception e) {
        // }

        FWConfigurationLoader.initConfig("config.xml", "OC4J_IVO_AEServer", "IVO_AEServer");

        initDb();

    }

    private void initDb() {
        UOWDataSource uowds = (UOWDataSource) TransactionManager.getInstance().createUOWDataSource();
        DataSourceSession.registerDataSource(uowds);
        uowds.begin();
    }

}
