package com.AgustinMontoya.desafio.ddd.sell.values;

import co.com.sofka.domain.generic.Identity;

public class ProductID extends Identity {
    public ProductID() {

    }
    public ProductID(String id){
        super(id);
    }
    public static ProductID of(String id){
        return new ProductID(id);
    }
}
