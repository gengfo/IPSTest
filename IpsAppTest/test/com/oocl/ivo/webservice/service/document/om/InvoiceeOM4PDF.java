package com.oocl.ivo.webservice.service.document.om;

import com.oocl.ivo.domain.entity.profile.invoicee.Invoicee;

public class InvoiceeOM4PDF {
    
    public static Invoicee buildInvoicee(){
        Invoicee invoicee = new Invoicee();
        
        invoicee.setCollectionOffice(ServiceOfficeOM4PDF.buildServiceOffice());
        invoicee.setName("test invoicee");
        invoicee.setAddress(AddressOM4PDF.buildAddress());
        invoicee.setShowShipment(true);
        //ivoicee.setActive(active)
        
        
        return invoicee;
    }

}
