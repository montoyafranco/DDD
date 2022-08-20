package com.AgustinMontoya.desafio.ddd.store;

import co.com.sofka.domain.generic.AggregateEvent;
import com.AgustinMontoya.desafio.ddd.store.events.StoreCreated;
import com.AgustinMontoya.desafio.ddd.store.values.AddressStore;
import com.AgustinMontoya.desafio.ddd.store.values.StatusStore;
import com.AgustinMontoya.desafio.ddd.store.values.StoreID;

public class Store extends AggregateEvent<StoreID> {
    protected StatusStore statusStore;
    protected  AddressStore addressStore;
    protected Owner owner;
    protected Deposit deposit;
    protected Manager manager;




    public Store(StoreID entityId, AddressStore addressStore, StatusStore statusStore) {
        super(entityId);
        appendChange(new StoreCreated(addressStore,statusStore)).apply();
    }
}
