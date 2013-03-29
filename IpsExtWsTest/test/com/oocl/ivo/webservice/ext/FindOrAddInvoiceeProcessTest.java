package com.oocl.ivo.webservice.ext;

import junit.framework.TestCase;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.oocl.ivo.webservice.publish.proxy.IVOExternalWebServiceProxy;
import com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoV2DTO;

public class FindOrAddInvoiceeProcessTest extends TestCase {

	public static Logger logger = LogManager
			.getLogger(FindOrAddInvoiceeProcessTest.class);

	// public static void main(String args[]) {
	//
	// }

	public static void ptestAddInvoiceeBase() throws Exception {

		IVOExternalWebServiceProxy proxy = new IVOExternalWebServiceProxy();

		com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_FindOrAddInvoiceeDTO inputDto = new com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_FindOrAddInvoiceeDTO();

		inputDto.setWebserviceKey("6f5946520c9b11dfad31f5b962d5fed3");

		inputDto.setOfficeCode("SHA");

		String ivceName = "Test IPS2111 " + System.currentTimeMillis();
		inputDto.setInvoiceeName(ivceName);
		System.out.println("ivceName " + ivceName);

		inputDto.setCompSapCode("2271");

		// sit
		// proxy._setSoapURL("http://ipssitweb:8607/IVO_AEServer/IVOExternalWebService");

		// localhost
		proxy._setSoapURL("http://localhost:8888/IVO_AEServer/IVOExternalWebService");

		// str
		// http://shalxdv2:7778
		// proxy._setSoapURL("http://shalxdv2:7778/IVO_AEServer/IVOExternalWebService");

		com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_FindOrAddInvoiceeResultDTO result = null;
		result = proxy.findOrAddInvoicee(inputDto);

		com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoV2DTO resultDto = result
				.getInvoicee();

		logger.debug("Inser invociee oid in base -> "
				+ resultDto.getInvoiceeOid());

		assertEquals("", "SHA", resultDto.getControlOffice().getOfficeCode());
		assertEquals("", "2271", resultDto.getCompanySapCode());
		// assertEquals("", "INT WITH IPS2111", resultDto.getInvoiceeName()
		// .substring(0, "INT WITH IPS2111".length()));

		// assertEquals(null, resultDto.getAddressLine1());
		// assertEquals(null, resultDto.getAddressLine2());
		// assertEquals(null, resultDto.getAddressLine3());
		// assertEquals(null, resultDto.getAddressLine4());

		if (result == null) {
			logger.debug(" === result is null === ");
		} else {
			logger.debug("Done");
		}

	}
	
	
	public static void testAddInvoiceeCanFoundBySapCode() throws Exception {

		IVOExternalWebServiceProxy proxy = new IVOExternalWebServiceProxy();

		com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_FindOrAddInvoiceeDTO inputDto = new com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_FindOrAddInvoiceeDTO();

		inputDto.setWebserviceKey("6f5946520c9b11dfad31f5b962d5fed3");

		inputDto.setOfficeCode("SHA");
		inputDto.setCompSapCode("2271");

		// sit
		proxy._setSoapURL("http://ipssitweb:8607/IVO_AEServer/IVOExternalWebService");

		// localhost
		//proxy._setSoapURL("http://localhost:8888/IVO_AEServer/IVOExternalWebService");

		// str
		// http://shalxdv2:7778
		// proxy._setSoapURL("http://shalxdv2:7778/IVO_AEServer/IVOExternalWebService");

		com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_FindOrAddInvoiceeResultDTO result = null;
		result = proxy.findOrAddInvoicee(inputDto);

		com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoV2DTO resultDto = result
				.getInvoicee();

		logger.debug("Inser invociee oid in base -> "
				+ resultDto.getInvoiceeOid());

		assertEquals("", "SHA", resultDto.getControlOffice().getOfficeCode());
		assertEquals("", "2271", resultDto.getCompanySapCode());
		// assertEquals("", "INT WITH IPS2111", resultDto.getInvoiceeName()
		// .substring(0, "INT WITH IPS2111".length()));

		// assertEquals(null, resultDto.getAddressLine1());
		// assertEquals(null, resultDto.getAddressLine2());
		// assertEquals(null, resultDto.getAddressLine3());
		// assertEquals(null, resultDto.getAddressLine4());

		if (result == null) {
			logger.debug(" === result is null === ");
		} else {
			logger.debug("Done");
		}

	}


	public static void ptestAddInvoiceeCanFound() throws Exception {

		IVOExternalWebServiceProxy proxy = new IVOExternalWebServiceProxy();

		com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_FindOrAddInvoiceeDTO inputDto = new com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_FindOrAddInvoiceeDTO();

		inputDto.setWebserviceKey("6f5946520c9b11dfad31f5b962d5fed3");

		inputDto.setOfficeCode("SHA");

		String ivceName = "Test IPS2111 " + System.currentTimeMillis();
		// inputDto.setInvoiceeName(ivceName);

		inputDto.setInvoiceeName("BONNY COMPOSITE- TECH (TONGXIANG) LTD.");

		System.out.println("ivceName " + ivceName);

		inputDto.setCompSapCode("2271");

		// sit
		// proxy._setSoapURL("http://ipssitweb:8607/IVO_AEServer/IVOExternalWebService");

		// localhost
		proxy._setSoapURL("http://localhost:8888/IVO_AEServer/IVOExternalWebService");

		// str
		// http://shalxdv2:7778
		// proxy._setSoapURL("http://shalxdv2:7778/IVO_AEServer/IVOExternalWebService");

		com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_FindOrAddInvoiceeResultDTO result = null;
		result = proxy.findOrAddInvoicee(inputDto);

		com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoV2DTO resultDto = result
				.getInvoicee();

		logger.debug("Inser invociee oid in base -> "
				+ resultDto.getInvoiceeOid());

		assertEquals("", "SHA", resultDto.getControlOffice().getOfficeCode());
		assertEquals("", "2271", resultDto.getCompanySapCode());
		// assertEquals("", "INT WITH IPS2111", resultDto.getInvoiceeName()
		// .substring(0, "INT WITH IPS2111".length()));

		// assertEquals(null, resultDto.getAddressLine1());
		// assertEquals(null, resultDto.getAddressLine2());
		// assertEquals(null, resultDto.getAddressLine3());
		// assertEquals(null, resultDto.getAddressLine4());

		if (result == null) {
			logger.debug(" === result is null === ");
		} else {
			logger.debug("Done");
		}

	}

	public static void ptestAddInvoiceeBaseAndEmail() throws Exception {

		IVOExternalWebServiceProxy proxy = new IVOExternalWebServiceProxy();

		com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_FindOrAddInvoiceeDTO inputDto = new com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_FindOrAddInvoiceeDTO();

		inputDto.setWebserviceKey("6f5946520c9b11dfad31f5b962d5fed3");

		inputDto.setOfficeCode("SHA");
		inputDto.setEmail("gengfo@gmail.com");

		String iname = "INT WITH IPS2111" + System.currentTimeMillis();

		inputDto.setInvoiceeName(iname);
		System.out.println(iname);

		inputDto.setCompSapCode("2271");

		// sit
		// proxy._setSoapURL("http://ipssitweb:8607/IVO_AEServer/IVOExternalWebService");

		// localhost
		proxy._setSoapURL("http://localhost:8888/IVO_AEServer/IVOExternalWebService");

		com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_FindOrAddInvoiceeResultDTO result = null;
		result = proxy.findOrAddInvoicee(inputDto);

		com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoV2DTO resultDto = result
				.getInvoicee();

		logger.debug("Inser invociee oid in testAddInvoiceeBaseAndEmail -> "
				+ resultDto.getInvoiceeOid());

		assertEquals("", "SHA", resultDto.getControlOffice().getOfficeCode());
		assertEquals("", "2271", resultDto.getCompanySapCode());
		assertEquals("", "INT WITH IPS2111", resultDto.getInvoiceeName()
				.substring(0, "INT WITH IPS2111".length()));

		assertEquals("", "Email", resultDto.getDistOpiton());

		assertEquals(".", resultDto.getAddressLine1());
		assertEquals(null, resultDto.getAddressLine2());
		assertEquals(null, resultDto.getAddressLine3());
		assertEquals(null, resultDto.getAddressLine4());

		if (result == null) {
			logger.debug(" === result is null === ");
		} else {
			logger.debug("Done");
		}

	}

	public static void ptestAddInvoiceeBaseAndAddress() throws Exception {

		IVOExternalWebServiceProxy proxy = new IVOExternalWebServiceProxy();

		com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_FindOrAddInvoiceeDTO inputDto = new com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_FindOrAddInvoiceeDTO();

		inputDto.setWebserviceKey("6f5946520c9b11dfad31f5b962d5fed3");

		inputDto.setOfficeCode("SHA");

		String ivceName = "Test IPS2111 " + System.currentTimeMillis();
		inputDto.setInvoiceeName(ivceName);
		System.out.println("ivceName " + ivceName);

		inputDto.setCompSapCode("2271");
		inputDto.setAddressLine1("addr1");
		inputDto.setAddressLine2("addr2");
		inputDto.setAddressLine3("addr3");
		inputDto.setAddressLine4("addr4");

		// sit
		// proxy._setSoapURL("http://ipssitweb:8607/IVO_AEServer/IVOExternalWebService");

		// localhost
		proxy._setSoapURL("http://localhost:8888/IVO_AEServer/IVOExternalWebService");

		com.oocl.ivo.webservice.publish.proxy.com_oocl_ivo_webservice_dto_interfaces_invoicee_FindOrAddInvoiceeResultDTO result = null;
		result = proxy.findOrAddInvoicee(inputDto);

		com_oocl_ivo_webservice_dto_interfaces_invoicee_InvoiceeInfoV2DTO resultDto = result
				.getInvoicee();

		logger.debug("Inser invociee oid in testAddInvoiceeBaseAndAddress -> "
				+ resultDto.getInvoiceeOid());

		assertEquals("", "SHA", resultDto.getControlOffice().getOfficeCode());
		assertEquals("", "2271", resultDto.getCompanySapCode());
		assertEquals("", ivceName, resultDto.getInvoiceeName());

		assertEquals("addr1", resultDto.getAddressLine1());
		assertEquals("addr2", resultDto.getAddressLine2());
		assertEquals("addr3", resultDto.getAddressLine3());
		assertEquals("addr4", resultDto.getAddressLine4());

		if (result == null) {
			logger.debug(" === result is null === ");
		} else {
			logger.debug("Done");
		}

	}

}
