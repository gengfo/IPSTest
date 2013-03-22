package com.oocl.ivo.webservice.service.document.om;

import com.oocl.ivo.domain.entity.common.util.Phone;

public class PhoneOM4PDF {

    public static Phone buildPhone() {
        Phone phone = new Phone();
        phone.setAreaCode("21");
        phone.setNumber("12345678");
        return phone;
    }

}
