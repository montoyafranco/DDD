package com.AgustinMontoya.desafio.ddd.sell.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.Product;
import com.AgustinMontoya.desafio.ddd.sell.values.ProductID;
import com.AgustinMontoya.desafio.ddd.sell.values.ProductName;
import com.AgustinMontoya.desafio.ddd.sell.values.ProductPrice;

public class ProductCreated extends DomainEvent {
    private final ProductID entityId;
    private final ProductName productName;
    private final ProductPrice productPrice;

    public ProductCreated(ProductID entityId, ProductName productName, ProductPrice productPrice){
        super("sofka.sell.productcreated");
        this.entityId = entityId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public ProductID getEntityId() {
        return entityId;
    }

    public ProductName getProductName() {
        return productName;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }
}
