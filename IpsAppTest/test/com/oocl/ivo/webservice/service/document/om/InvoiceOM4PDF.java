package com.oocl.ivo.webservice.service.document.om;

import java.util.ArrayList;
import java.util.List;

import com.oocl.ivo.domain.entity.arap.ar.invoice.Invoice;
import com.oocl.ivo.domain.entity.shipment.Shipment;

public class InvoiceOM4PDF {

    public static Invoice buildARNote() {

        Invoice invoice = new Invoice();

        invoice.setColOffice(ServiceOfficeOM4PDF.buildServiceOffice());
        invoice.setInvoicee(InvoiceeOM4PDF.buildInvoicee());
        invoice.setPayableBy("gengfo");
        
        List<Shipment> shipments = new ArrayList<Shipment>();
        shipments.add(ShipmentOM4PDF.buildShipment());
        
        invoice.setShipments(shipments);

        return invoice;

    }

}
