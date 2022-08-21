package com.AgustinMontoya.desafio.ddd.sell.values;

import co.com.sofka.domain.generic.Identity;

public class SellerID extends Identity {
    public SellerID() {

    }
    public SellerID(String id){
        super(id);
    }
    public static SellerID  of(String id){
        return new SellerID(id);
    }
}
