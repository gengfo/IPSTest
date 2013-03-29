package com.oocl.ivo.webservice.ext;

import junit.framework.TestCase;

import com.oocl.ivo.webservice.publish.proxy.IVOExternalWebServiceProxy;
import com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_charge_SearchChargeCodeCriteriaDTO;
import com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_charge_SearchChargeCodeResultDTO;

public class SearchChargeCodeProcessTest extends TestCase {

    public void testSimpleSearchChargeCode() {

        IVOExternalWebServiceProxy proxy = new IVOExternalWebServiceProxy();

        com_oocl_ivo_webservice_dto_interfaces_charge_SearchChargeCodeCriteriaDTO inputDto = new com_oocl_ivo_webservice_dto_interfaces_charge_SearchChargeCodeCriteriaDTO();

        inputDto.setWebserviceKey("eaTf982*bmaf$bah*fa&4432mbai");
        inputDto.setSystemName("OP");
        inputDto.setBizGroupCode("OPS");

        // sit
        proxy._setSoapURL("http://ipssitweb:8607/IVO_AEServer/IVOExternalWebService");

        // localhost
        //proxy._setSoapURL("http://localhost:8888/IVO_AEServer/IVOExternalWebService");

        com_oocl_ivo_webservice_dto_interfaces_charge_SearchChargeCodeResultDTO resultDto = null;
        try {

            resultDto = proxy.searchChargeCode(inputDto);

        } catch (Exception e) {
            e.printStackTrace();
        }

        assertNotNull(resultDto);

        if (resultDto == null) {
            // logger.debug(" === result is null === ");
        } else {
            // logger.debug("Done");
        }
    }

}
