package com.AgustinMontoya.desafio.ddd.store;

import co.com.sofka.domain.generic.Entity;
import com.AgustinMontoya.desafio.ddd.store.values.DepositCapacity;
import com.AgustinMontoya.desafio.ddd.store.values.DepositID;
import com.AgustinMontoya.desafio.ddd.store.values.StoreID;

public class Deposit extends Entity<DepositID>  {
    private  DepositCapacity depositCapacity;

    public Deposit(DepositID depositID, DepositCapacity depositCapacity ) {
        super(depositID);

        this.depositCapacity = depositCapacity;
    }

    public DepositCapacity depositCapacity() {
        return depositCapacity;
    }
}
