package com.oocl.ivo.webservice.service.document.om;

import java.math.BigDecimal;

import com.oocl.ivo.domain.entity.arap.Money;

public class MoneyOM4PDF {

    public static Money buildMoney() {

        Money money = new Money();

        money.setAmount(new BigDecimal("10"));
        money.setCurrency(CurrencyOM4PDF.buildCurrency());

        return money;

    }

}
