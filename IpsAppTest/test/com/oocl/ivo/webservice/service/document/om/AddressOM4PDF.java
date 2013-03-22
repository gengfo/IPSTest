package com.oocl.ivo.webservice.service.document.om;

import com.oocl.ivo.domain.entity.common.util.Address;

public class AddressOM4PDF {

    public static Address buildAddress() {
        Address address = new Address();
        
        address.setCity(GeoLocationOM4PDF.buildCity());
        
        //office.getAddress().getCity().getCountry().getOid()
        return address;
    }

}
