package com.AgustinMontoya.desafio.ddd.sell.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;
import com.AgustinMontoya.desafio.ddd.sell.values.SellerName;

public class UpdateNameSeller extends Command {
    private SellerName sellerName;
    private SaleID saleID;

    public UpdateNameSeller(SellerName sellerName, SaleID saleID) {
        this.sellerName = sellerName;
        this.saleID = saleID;
    }

    public SellerName getSellerName() {
        return sellerName;
    }

    public SaleID getSaleID() {
        return saleID;
    }
}
