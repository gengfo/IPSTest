package com.oocl.ivo.webservice.service.document.om;

import com.oocl.ivo.domain.entity.profile.ServiceOffice;

public class ServiceOfficeOM4PDF {

    public static ServiceOffice buildServiceOffice() {
        ServiceOffice so = new ServiceOffice();
        so.setOid("54");
        so.setCode("SHA");
        so.setComShortName("OLCL");

        so.setAddress(AddressOM4PDF.buildAddress());
        so.setContact(ContactOM4PDF.buildContact());

        return so;

    }
}
