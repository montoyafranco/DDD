package com.AgustinMontoya.desafio.ddd.sell.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;
import com.AgustinMontoya.desafio.ddd.sell.values.SellerID;
import com.AgustinMontoya.desafio.ddd.sell.values.SellerName;
import com.AgustinMontoya.desafio.ddd.sell.values.SellerSalesQuantity;

public class AddSeller extends Command {
    private  SaleID entityId;
    private  SellerName sellerName;
    private  SellerSalesQuantity sellerSalesQuantity;

    public AddSeller(SaleID entityId, SellerName sellerName, SellerSalesQuantity sellerSalesQuantity) {
        this.entityId = entityId;
        this.sellerName = sellerName;
        this.sellerSalesQuantity = sellerSalesQuantity;
    }

    public SaleID getEntityId() {
        return entityId;
    }

    public SellerName getSellerName() {
        return sellerName;
    }

    public SellerSalesQuantity getSellerSalesQuantity() {
        return sellerSalesQuantity;
    }
}
