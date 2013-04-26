package com.oocl.ivo.webservice.ext;

import junit.framework.TestCase;

import com.oocl.ivo.webservice.publish.proxy.IVOExternalWebServiceProxy;
import com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_charge_ChargeGeneralInfoDTOV2;
import com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_charge_SearchChargeCodeCriteriaDTO;
import com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_charge_SearchChargeCodeResultDTOV2;

public class SearchChargeCodeProcessV2Test extends TestCase {

    public void testSimpleSearchChargeCode() {

        IVOExternalWebServiceProxy proxy = new IVOExternalWebServiceProxy();

        com_oocl_ivo_webservice_dto_interfaces_charge_SearchChargeCodeCriteriaDTO inputDto = new com_oocl_ivo_webservice_dto_interfaces_charge_SearchChargeCodeCriteriaDTO();

        inputDto.setWebserviceKey("eaTf982*bmaf$bah*fa&4432mbai");
        inputDto.setSystemName("OP");
        inputDto.setBizGroupCode("OPS");

        // sit
        proxy._setSoapURL("http://ipssitweb:8607/IVO_AEServer/IVOExternalWebService");

        // localhost
        // proxy._setSoapURL("http://localhost:8888/IVO_AEServer/IVOExternalWebService");

        com_oocl_ivo_webservice_dto_interfaces_charge_SearchChargeCodeResultDTOV2 resultDto = null;
        try {

            resultDto = proxy.searchChargeCodeV2(inputDto);
            assertNotNull(resultDto);

            showChargeCodeResult(resultDto);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (resultDto == null) {
            // logger.debug(" === result is null === ");
        } else {
            // logger.debug("Done");
        }
    }

    private static void showChargeCodeResult(
            com_oocl_ivo_webservice_dto_interfaces_charge_SearchChargeCodeResultDTOV2 resultDto) {

        com_oocl_ivo_webservice_dto_interfaces_charge_ChargeGeneralInfoDTOV2[] ciDtos = resultDto
                .getChargesInfoDtos();
        for (com_oocl_ivo_webservice_dto_interfaces_charge_ChargeGeneralInfoDTOV2 ciDto : ciDtos) {

            System.out.print("--->");
            System.out.println(ciDto.getChargeCode());

            System.out.println(ciDto.getChargeName());
            System.out.println(ciDto.getManifestIndi());
            System.out.println(ciDto.getStatus());

            showBizSubUnits(ciDto.getBizSubUnits());
        }

    }

    private static void showBizSubUnits(String[] bizs) {
        for (String biz : bizs) {
            System.out.println(biz);
        }

    }

}
