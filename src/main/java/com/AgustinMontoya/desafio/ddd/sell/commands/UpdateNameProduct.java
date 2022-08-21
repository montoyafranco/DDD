package com.AgustinMontoya.desafio.ddd.sell.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.sell.values.ProductName;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;

public class UpdateNameProduct extends Command {
    private ProductName productName ;
    private SaleID saleID;

    public UpdateNameProduct(ProductName productName, SaleID saleID) {
        this.productName = productName;
        this.saleID = saleID;
    }

    public ProductName getProductName() {
        return productName;
    }

    public SaleID getSaleID() {
        return saleID;
    }
}
