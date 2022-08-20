package com.AgustinMontoya.desafio.ddd.store.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.store.values.OwnerPhone;
import com.AgustinMontoya.desafio.ddd.store.values.StoreID;

public class UpdatePhoneOwner extends Command {
    private OwnerPhone ownerPhone;
    private StoreID storeID;

    public UpdatePhoneOwner(OwnerPhone ownerPhone, StoreID storeID) {
        this.ownerPhone = ownerPhone;
        this.storeID = storeID;
    }

    public OwnerPhone getOwnerPhone() {
        return ownerPhone;
    }

    public StoreID getStoreID() {
        return storeID;
    }
}
