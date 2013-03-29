package com.oocl.ivo.webservice.ext;

import junit.framework.TestCase;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.oocl.ivo.webservice.publish.proxy.IVOExternalWebServiceProxy;
import com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoV2DTO;
import com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeResultV2DTO;
import com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeV2DTO;

public class SearchInvoiceeV2ProcessTest extends TestCase {
    public static Logger logger = LogManager.getLogger(FindOrAddInvoiceeProcessTest.class);

    public static void ptestAddInvoiceeBaseWithAllParameters() throws Exception {

        IVOExternalWebServiceProxy proxy = new IVOExternalWebServiceProxy();

        com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeV2DTO inputDto = new com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeV2DTO();

        com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_common_OfficeDTO office = new com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_common_OfficeDTO();
        office.setOfficeCode("SHA");
        office.setCompanyShortName("OLCL");
        inputDto.setControlOffice(office);

        inputDto.setInvoiceeName("BUNDHAND MEDICAL AND SAFETY PRODUCTS COMPANY LIMITED");

        inputDto.setCompanySAPCode("2271");
        inputDto.setWebserviceKey("6f5946520c9b11dfad31f5b962d5fed3");

        inputDto.setStatus("Active");
        inputDto.setSystemName("ICS");

        proxy._setSoapURL(getLocalUrl());

        com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeResultV2DTO result = null;

        result = proxy.searchInvoiceeV2(inputDto);

        com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoV2DTO[] resutlDtos = result.getInvoicees();

        if (null != resutlDtos && resutlDtos.length > 0) {
            for (int i = 0; i < resutlDtos.length; i++) {
                com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoV2DTO resutlDto = resutlDtos[i];
                assertTrue(resutlDto.getInvoiceeName().contains(
                        "BUNDHAND MEDICAL AND SAFETY PRODUCTS COMPANY LIMITED"));
            }

            logger.debug(" === result is null === ");
        } else {

            logger.debug("Done");
        }

    }

    public static void ptestAddInvoiceeBaseWithOfficeSapCode() throws Exception {

        IVOExternalWebServiceProxy proxy = new IVOExternalWebServiceProxy();

        com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeV2DTO inputDto = new com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeV2DTO();

        com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_common_OfficeDTO office = new com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_common_OfficeDTO();
        office.setOfficeCode("SHA");
        // office.setCompanyShortName("OLCL");
        inputDto.setControlOffice(office);

        inputDto.setInvoiceeName("BUNDHAND MEDICAL AND SAFETY PRODUCTS COMPANY LIMITED");

        inputDto.setCompanySAPCode("2271");
        inputDto.setWebserviceKey("6f5946520c9b11dfad31f5b962d5fed3");

        inputDto.setStatus("Active");
        inputDto.setSystemName("ICS");

        // sit url
        proxy._setSoapURL(getSitUrl());

        com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeResultV2DTO result = null;
        result = proxy.searchInvoiceeV2(inputDto);

        com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoV2DTO[] resutlDtos = result.getInvoicees();

        assertTrue(resutlDtos.length > 0);

        if (null != resutlDtos && resutlDtos.length > 0) {
            for (int i = 0; i < resutlDtos.length; i++) {
                com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoV2DTO resutlDto = resutlDtos[i];
                assertTrue(resutlDto.getInvoiceeName().contains(
                        "BUNDHAND MEDICAL AND SAFETY PRODUCTS COMPANY LIMITED"));
            }

            logger.debug(" === result is null === ");
        } else {

            logger.debug("Done");
        }

    }

    public static void testSearchInvoiceeV2BaseWithInvoiceeSapCode() throws Exception {

        IVOExternalWebServiceProxy proxy = new IVOExternalWebServiceProxy();

        com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeV2DTO inputDto = new com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeV2DTO();

        com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_common_OfficeDTO office = new com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_common_OfficeDTO();
        office.setOfficeCode("SHA");
        office.setCompanyShortName("OLCL");
        inputDto.setControlOffice(office);

        // inputDto.setInvoiceeSapCode("2200002183");
        inputDto.setInvoiceeSapCode("2200030361");

        inputDto.setWebserviceKey("6f5946520c9b11dfad31f5b962d5fed3");

        inputDto.setStatus("Active");
        inputDto.setSystemName("ICS");

        proxy._setSoapURL(getSitUrl());
        // proxy._setSoapURL(getLocalUrl());

        com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeResultV2DTO result = null;
        result = proxy.searchInvoiceeV2(inputDto);

        com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoV2DTO[] resutlDtos = result.getInvoicees();

        // assertTrue(resutlDtos.length > 0);

        if (null != resutlDtos && resutlDtos.length > 0) {
            for (int i = 0; i < resutlDtos.length; i++) {
                com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoV2DTO resutlDto = resutlDtos[i];
                assertTrue(resutlDto.getInvoiceeName().contains(
                        "BUNDHAND MEDICAL AND SAFETY PRODUCTS COMPANY LIMITED"));
            }

            logger.debug(" === result is null === ");
        } else {

            logger.debug("Done");
        }

    }

    private static String getLocalUrl() {
        return "http://localhost:8888/IVO_AEServer/IVOExternalWebService";
    }

    private static String getSitUrl() {
        return "http://ipssitweb:8607/IVO_AEServer/IVOExternalWebService";
    }
}
