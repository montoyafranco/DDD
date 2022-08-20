package com.AgustinMontoya.desafio.ddd.store.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.store.values.AddressStore;
import com.AgustinMontoya.desafio.ddd.store.values.StatusStore;
import com.AgustinMontoya.desafio.ddd.store.values.StoreID;

public class CreateStore extends Command {

    private final StoreID entityId;
    private final AddressStore addressStore;
    private final StatusStore statusStore;

    public CreateStore(StoreID entityId, AddressStore addressStore, StatusStore statusStore){

        this.entityId = entityId;
        this.addressStore = addressStore;
        this.statusStore = statusStore;
    }

    public StoreID getEntityId() {
        return entityId;
    }

    public AddressStore getAddressStore() {
        return addressStore;
    }

    public StatusStore getStatusStore() {
        return statusStore;
    }
}
