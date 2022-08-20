package com.AgustinMontoya.desafio.ddd.sell.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.Sell;
import com.AgustinMontoya.desafio.ddd.sell.values.SellerID;
import com.AgustinMontoya.desafio.ddd.sell.values.SellerName;
import com.AgustinMontoya.desafio.ddd.sell.values.SellerSalesQuantity;

public class SellerCreated extends DomainEvent {
    private final SellerID entityId;
    private final SellerName sellerName;
    private final SellerSalesQuantity sellerSalesQuantity;

    public SellerCreated(SellerID entityId, SellerName sellerName , SellerSalesQuantity sellerSalesQuantity){
        super("sofka.sell.sellercreated");
        this.entityId = entityId;
        this.sellerName = sellerName;
        this.sellerSalesQuantity = sellerSalesQuantity;
    }

    public SellerID getEntityId() {
        return entityId;
    }

    public SellerName getSellerName() {
        return sellerName;
    }

    public SellerSalesQuantity getSellerSalesQuantity() {
        return sellerSalesQuantity;
    }
}
