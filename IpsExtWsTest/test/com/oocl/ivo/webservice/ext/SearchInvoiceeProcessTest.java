package com.oocl.ivo.webservice.ext;

import junit.framework.TestCase;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.oocl.ivo.webservice.publish.proxy.IVOExternalWebServiceProxy;
import com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoDTO;
import com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeDTO;
import com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeResultDTO;

public class SearchInvoiceeProcessTest extends TestCase {
	public static Logger logger = LogManager
			.getLogger(FindOrAddInvoiceeProcessTest.class);

	public static void ptestAddInvoiceeBaseWithAllParameters() throws Exception {

		IVOExternalWebServiceProxy proxy = new IVOExternalWebServiceProxy();

		com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeDTO inputDto = new com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeDTO();

		com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_common_OfficeDTO office = new com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_common_OfficeDTO();
		office.setOfficeCode("SHA");
		office.setCompanyShortName("OLCL");
		inputDto.setControlOffice(office);

		inputDto.setInvoiceeName("BUNDHAND MEDICAL AND SAFETY PRODUCTS COMPANY LIMITED");

		inputDto.setWebserviceKey("6f5946520c9b11dfad31f5b962d5fed3");

		inputDto.setStatus("Active");
		inputDto.setSystemName("ICS");

		proxy._setSoapURL(getWSUrl());

		com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeResultDTO result = null;
		result = proxy.searchInvoicee(inputDto);

		com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoDTO[] resutlDtos = result
				.getInvoicees();

		if (null != resutlDtos && resutlDtos.length > 0) {
			for (int i = 0; i < resutlDtos.length; i++) {
				com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoDTO resutlDto = resutlDtos[i];
				assertTrue(resutlDto.getInvoiceeName().contains(
						"BUNDHAND MEDICAL AND SAFETY PRODUCTS COMPANY LIMITED"));
			}

			logger.debug(" === result is null === ");
		} else {

			logger.debug("Done");
		}

	}

	public static void testAddInvoiceeBaseWithInvoiceeNameOnly()
			throws Exception {

		IVOExternalWebServiceProxy proxy = new IVOExternalWebServiceProxy();

		com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeDTO inputDto = new com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeDTO();

		com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_common_OfficeDTO office = new com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_common_OfficeDTO();

		// office.setOfficeCode("SHA");
		// office.setCompanyShortName("OLCL");
		// inputDto.setControlOffice(office);
		inputDto.setInvoiceeName("BUNDHAND MEDICAL AND SAFETY PRODUCTS COMPANY LIMITED");

		inputDto.setWebserviceKey("6f5946520c9b11dfad31f5b962d5fed3");

		inputDto.setStatus("Active");
		inputDto.setSystemName("ICS");

		proxy._setSoapURL(getWSUrl());

		com_oocl_ivo_webservice_dto_interfaces_invoicee_SearchInvoiceeResultDTO result = null;
		result = proxy.searchInvoicee(inputDto);

		com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoDTO[] resutlDtos = result
				.getInvoicees();

		assertTrue(resutlDtos.length > 0);

		if (null != resutlDtos && resutlDtos.length > 0) {
			for (int i = 0; i < resutlDtos.length; i++) {
				com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoDTO resutlDto = resutlDtos[i];
				assertTrue(resutlDto.getInvoiceeName().contains(
						"BUNDHAND MEDICAL AND SAFETY PRODUCTS COMPANY LIMITED"));
			}

			logger.debug(" === result is null === ");
		} else {

			logger.debug("Done");
		}

	}

	private static String getWSUrl() {
		return "http://localhost:8888/IVO_AEServer/IVOExternalWebService";
	}

}
