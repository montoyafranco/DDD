package com.AgustinMontoya.desafio.ddd.store;

import co.com.sofka.domain.generic.Entity;
import com.AgustinMontoya.desafio.ddd.store.values.StoreID;

public class Deposit extends Entity<StoreID>  {
    public Deposit(StoreID entityId) {
        super(entityId);
    }
}
