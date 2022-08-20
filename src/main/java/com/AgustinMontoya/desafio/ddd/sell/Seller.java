package com.AgustinMontoya.desafio.ddd.sell;

import co.com.sofka.domain.generic.Entity;
import com.AgustinMontoya.desafio.ddd.sell.values.*;

import java.util.Objects;

public class Seller extends Entity<SellerID> {

    protected SellerName sellerName;
    protected SellerSalesQuantity sellerSalesQuantity;

    public Seller(SellerID entityId, SellerName sellerName , SellerSalesQuantity sellerSalesQuantity) {
        super(entityId);

        this.sellerName = sellerName;
        this.sellerSalesQuantity = sellerSalesQuantity;
    }
    //comportamientos
    public void updateSellerName(SellerName sellerName){
        this.sellerName = Objects.requireNonNull(sellerName);

    }
    public void cumpleMetasVentas(SellerSalesQuantity sellerSalesQuantity){
        this.sellerSalesQuantity = Objects.requireNonNull(sellerSalesQuantity);
    }

    public SellerName sellerName() {
        return sellerName;
    }

    public SellerSalesQuantity sellerSalesQuantity() {
        return sellerSalesQuantity;
    }
}
