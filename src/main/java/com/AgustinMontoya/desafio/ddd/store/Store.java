package com.AgustinMontoya.desafio.ddd.store;

import co.com.sofka.domain.generic.AggregateEvent;
import com.AgustinMontoya.desafio.ddd.store.values.AddressStore;
import com.AgustinMontoya.desafio.ddd.store.values.StoreID;

public class Store extends AggregateEvent<StoreID> {

    public Store(StoreID entityId, AddressStore addressStore) {
        super(entityId);
    }
}
