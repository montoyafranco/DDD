package com.AgustinMontoya.desafio.ddd.sell.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.sell.values.ProductPrice;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;

public class UpdatePriceProduct extends Command {
    private ProductPrice productPrice;
    private SaleID saleID;

    public UpdatePriceProduct(ProductPrice productPrice, SaleID saleID) {
        this.productPrice = productPrice;
        this.saleID = saleID;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }

    public SaleID getSaleID() {
        return saleID;
    }
}
