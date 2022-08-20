package com.AgustinMontoya.desafio.ddd.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.values.AddressStore;

public class AddresUpdated extends DomainEvent {


    private final AddressStore addressStore;

    public AddresUpdated(AddressStore addressStore) {
        super("sofka.store.addresupdated");
        this.addressStore = addressStore;
    }

    public AddressStore getAddressStore() {
        return addressStore;
    }
}
