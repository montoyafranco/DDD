package com.AgustinMontoya.desafio.ddd.sell;

import co.com.sofka.domain.generic.Entity;
import com.AgustinMontoya.desafio.ddd.sell.values.*;

import java.util.Objects;

public class Product extends Entity<ProductID> {


    protected ProductName productName;
    protected ProductPrice productPrice;

    public Product(ProductID entityId,ProductName productName, ProductPrice productPrice) {
        super(entityId);

        this.productName = productName;
        this.productPrice = productPrice;
    }


    //comportamiento
    public void updateProductName(ProductName productName){
        this.productName = Objects.requireNonNull(productName);

    }
    public void updateProductPrice(ProductPrice productPrice){
        this.productPrice = Objects.requireNonNull(productPrice);
    }


    public ProductName productName() {
        return productName;
    }

    public ProductPrice productPrice() {
        return productPrice;
    }
}
