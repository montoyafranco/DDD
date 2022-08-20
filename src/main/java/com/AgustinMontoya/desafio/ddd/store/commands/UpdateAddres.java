package com.AgustinMontoya.desafio.ddd.store.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.store.values.AddressStore;
import com.AgustinMontoya.desafio.ddd.store.values.StoreID;

public class UpdateAddres extends Command {
    private StoreID storeID;
    private AddressStore addressStore;

    public UpdateAddres(StoreID storeID, AddressStore addressStore) {
        this.storeID = storeID;
        this.addressStore = addressStore;
    }

    public StoreID getStoreID() {
        return storeID;
    }

    public AddressStore getAddressStore() {
        return addressStore;
    }
}
