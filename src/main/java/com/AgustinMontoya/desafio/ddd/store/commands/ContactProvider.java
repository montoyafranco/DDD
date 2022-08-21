package com.AgustinMontoya.desafio.ddd.store.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.store.values.DepositCapacity;
import com.AgustinMontoya.desafio.ddd.store.values.StoreID;

public class ContactProvider extends Command {
    private DepositCapacity depositCapacity;
    private StoreID storeID;

    public ContactProvider(DepositCapacity depositCapacity, StoreID storeID) {
        this.depositCapacity = depositCapacity;
        this.storeID = storeID;
    }

    public DepositCapacity getDepositCapacity() {
        return depositCapacity;
    }

    public StoreID getStoreID() {
        return storeID;
    }
}
