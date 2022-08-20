package com.AgustinMontoya.desafio.ddd.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.values.AddressStore;
import com.AgustinMontoya.desafio.ddd.store.values.StatusStore;

public class StoreCreated extends DomainEvent {
    private final AddressStore addressStore;
    private final StatusStore statusStore;

    public StoreCreated(AddressStore addressStore, StatusStore statusStore){
        super("sofka.store.storecreated");
        this.addressStore = addressStore;
        this.statusStore = statusStore;



    }

    public AddressStore getAddressStore() {
        return addressStore;
    }

    public StatusStore getStatusStore() {
        return statusStore;
    }
}
