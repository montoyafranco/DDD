package com.AgustinMontoya.desafio.ddd.sell.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.values.SellerSalesQuantity;

public class ChequeadoMetasVentas extends DomainEvent {
    private final SellerSalesQuantity sellerSalesQuantity;

    public ChequeadoMetasVentas(SellerSalesQuantity sellerSalesQuantity){
        super("sofka.sell.chequeadometasventas");


        this.sellerSalesQuantity = sellerSalesQuantity;
    }

    public SellerSalesQuantity getSellerSalesQuantity() {
        return sellerSalesQuantity;
    }
}
