package com.AgustinMontoya.desafio.ddd.sell.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.values.ProductPrice;

public class ProductPriceUpdated extends DomainEvent {
    private final ProductPrice productPrice;

    public ProductPriceUpdated(ProductPrice productPrice){
        super("sofka.sell.productpriceupdated");
        this.productPrice = productPrice;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }
}
