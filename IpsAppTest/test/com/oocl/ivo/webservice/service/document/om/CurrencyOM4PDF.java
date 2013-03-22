package com.oocl.ivo.webservice.service.document.om;

import com.oocl.ivo.domain.entity.spdata.exgrate.Currency;

public class CurrencyOM4PDF {
    
    public static Currency buildCurrency(){
        Currency currency = new Currency();
        currency.setCode("CNY");
        
        return currency;
    }

}
