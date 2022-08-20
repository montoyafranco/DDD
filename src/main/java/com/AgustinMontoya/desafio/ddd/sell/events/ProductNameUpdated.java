package com.AgustinMontoya.desafio.ddd.sell.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.values.ProductName;

public class ProductNameUpdated extends DomainEvent {
    private final ProductName productName;

    public ProductNameUpdated(ProductName productName){
        super("sofka.sell.productnameupdated");
        this.productName = productName;
    }

    public ProductName getProductName() {
        return productName;
    }
}
