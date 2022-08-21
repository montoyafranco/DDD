package com.AgustinMontoya.desafio.ddd.sell.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;
import com.AgustinMontoya.desafio.ddd.sell.values.SellerSalesQuantity;

public class CumpleMetasVentas extends Command {
    private SellerSalesQuantity sellerSalesQuantity;
    private SaleID saleID;

    public CumpleMetasVentas(SellerSalesQuantity sellerSalesQuantity, SaleID saleID) {
        this.sellerSalesQuantity = sellerSalesQuantity;
        this.saleID = saleID;
    }

    public SellerSalesQuantity getSellerSalesQuantity() {
        return sellerSalesQuantity;
    }

    public SaleID getSaleID() {
        return saleID;
    }
}
