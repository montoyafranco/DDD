package com.AgustinMontoya.desafio.ddd.sell.values;

import co.com.sofka.domain.generic.Identity;

public class SaleID extends Identity {
    public SaleID() {

    }
    public SaleID(String id){
        super(id);
    }
    public static SaleID of(String id){
        return new SaleID(id);
    }
}
