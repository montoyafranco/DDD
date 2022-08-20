package com.AgustinMontoya.desafio.ddd.store.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.store.values.OwnerName;
import com.AgustinMontoya.desafio.ddd.store.values.OwnerPhone;
import com.AgustinMontoya.desafio.ddd.store.values.StoreID;

public class AddOwner extends Command {
    private OwnerName ownerName;
    private OwnerPhone ownerPhone;
    private StoreID storeID;

    public AddOwner(OwnerName ownerName, OwnerPhone ownerPhone, StoreID storeID) {
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.storeID = storeID;
    }

    public OwnerName getOwnerName() {
        return ownerName;
    }

    public OwnerPhone getOwnerPhone() {
        return ownerPhone;
    }

    public StoreID getStoreID() {
        return storeID;
    }
}
