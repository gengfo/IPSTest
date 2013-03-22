package com.oocl.ivo.webservice.service.document.om;

import com.oocl.ivo.domain.entity.common.util.Contact;

public class ContactOM4PDF {

    public static Contact buildContact() {
        Contact contact = new Contact();
        contact.setEmail("gengfo@oocl.com");
        contact.setFax(FaxOM4PDF.buildFax());

        contact.setPerson("gengfo");

        contact.setPhone(PhoneOM4PDF.buildPhone());

        return contact;
    }

}
