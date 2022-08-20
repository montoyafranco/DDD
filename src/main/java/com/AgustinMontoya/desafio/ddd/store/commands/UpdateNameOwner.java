package com.AgustinMontoya.desafio.ddd.store.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.store.values.OwnerName;
import com.AgustinMontoya.desafio.ddd.store.values.StoreID;

public class UpdateNameOwner extends Command {
    private OwnerName ownerName;
    private StoreID storeID;

    public UpdateNameOwner(OwnerName ownerName, StoreID storeID) {
        this.ownerName = ownerName;
        this.storeID = storeID;
    }

    public OwnerName getOwnerName() {
        return ownerName;
    }

    public StoreID getStoreID() {
        return storeID;
    }
}
