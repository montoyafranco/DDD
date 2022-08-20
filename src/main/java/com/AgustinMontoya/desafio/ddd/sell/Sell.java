package com.AgustinMontoya.desafio.ddd.sell;

import co.com.sofka.domain.generic.AggregateEvent;
import com.AgustinMontoya.desafio.ddd.sell.events.SaleCreated;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;
import com.AgustinMontoya.desafio.ddd.sell.values.Sale_Status;

public class Sell extends AggregateEvent<SaleID> {
    protected Sale_Status sale_status;
    protected Client client ;
    protected Product product;
    protected Seller seller;
    protected Ticket ticket;


    public Sell(SaleID entityId , Sale_Status sale_status) {
        super(entityId);
        appendChange(new SaleCreated(sale_status)).apply();
        subscribe(new SellChange(this));
    }
}
