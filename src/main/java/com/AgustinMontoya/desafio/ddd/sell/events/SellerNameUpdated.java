package com.AgustinMontoya.desafio.ddd.sell.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.values.SellerName;

public class SellerNameUpdated extends DomainEvent {
    private final SellerName sellerName;

    public SellerNameUpdated(SellerName sellerName){
        super("sofka.sell.sellernameupdated");
        this.sellerName = sellerName;
    }

    public SellerName getSellerName() {
        return sellerName;
    }
}
