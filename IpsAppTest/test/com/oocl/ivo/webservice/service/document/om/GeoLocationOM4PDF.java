package com.oocl.ivo.webservice.service.document.om;

import com.oocl.ivo.domain.entity.spdata.geo.GeoLocation;

public class GeoLocationOM4PDF {

    public static GeoLocation buildCity() {
        GeoLocation city = new GeoLocation();

        city.setCountry(buildCountry());
        // office.getAddress().getCity().getCountry().getOid()
        return city;
    }

    public static GeoLocation buildCountry() {
        GeoLocation country = new GeoLocation();

        country.setOid("24");
        country.setCode("CN");
        country.setName("China");

        // office.getAddress().getCity().getCountry().getOid()
        return country;
    }

}
