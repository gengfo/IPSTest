package com.oocl.ivo.webservice.service.document;

import com.oocl.ivo.BasedTestCase;
import com.oocl.ivo.domain.entity.arap.ar.invoice.Invoice;
import com.oocl.ivo.domain.entity.edoc.InvoiceDoc;
import com.oocl.ivo.frm.webservice.service.ServiceFactory;
import com.oocl.ivo.webservice.service.document.om.InvoiceOM4PDF;
import com.oocl.ivo.webservice.service.pdf.ds.DocService;
import com.oocl.ivo.webservice.service.pdf.ds.DocServiceImpl;

public class DocServiceImplTest extends BasedTestCase {

    private Invoice invoice;

    private DocService docService;

    private InvoiceDoc invoiceDoc;

    public void setUp() throws Exception {
        super.setUp();
        invoice = InvoiceOM4PDF.buildARNote();
        docService = (DocServiceImpl) ServiceFactory.getInstance().acquireService(DocService.class);
    }

    public void tearDown() {

    }

    public void testGenerateInvoiceDoc() {

        assertNotNull(invoice);
        assertNotNull(docService);

        invoiceDoc = docService.generateInvoiceDoc(invoice);

        
        assertEquals(invoice.getPayableBy(), invoiceDoc.getPayableBy());
        assertNotNull(invoiceDoc);

    }


}
