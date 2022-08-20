package com.AgustinMontoya.desafio.ddd.sell.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.sell.values.ProductID;
import com.AgustinMontoya.desafio.ddd.sell.values.ProductName;
import com.AgustinMontoya.desafio.ddd.sell.values.ProductPrice;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;

public class AddProduct extends Command {
    private SaleID entityId;
    private  ProductName productName;
    private  ProductPrice productPrice;

    public AddProduct(SaleID entityId, ProductName productName, ProductPrice productPrice) {
        this.entityId = entityId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public SaleID getEntityId() {
        return entityId;
    }

    public ProductName getProductName() {
        return productName;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }
}
