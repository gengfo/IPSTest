package com.oocl.ivo.webservice.service.document.om;

import com.oocl.ivo.domain.entity.common.util.Fax;

public class FaxOM4PDF {

    public static Fax buildFax() {
        Fax fax = new Fax();
        fax.setAreaCode("21");
        fax.setNumber("12345678");
        return fax;
    }

}
