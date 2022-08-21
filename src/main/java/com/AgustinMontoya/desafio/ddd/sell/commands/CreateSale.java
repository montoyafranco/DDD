package com.AgustinMontoya.desafio.ddd.sell.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;
import com.AgustinMontoya.desafio.ddd.sell.values.Sale_Status;

public class CreateSale extends Command {
    private  Sale_Status sale_status;
    private SaleID saleID;

    public CreateSale(Sale_Status sale_status, SaleID saleID) {
        this.sale_status = sale_status;
        this.saleID = saleID;
    }

    public Sale_Status getSale_status() {
        return sale_status;
    }

    public SaleID getSaleID() {
        return saleID;
    }
}
