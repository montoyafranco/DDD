package com.AgustinMontoya.desafio.ddd.store;

import co.com.sofka.domain.generic.EventChange;
import com.AgustinMontoya.desafio.ddd.store.events.DepositCreated;
import com.AgustinMontoya.desafio.ddd.store.events.StoreCreated;

public class StoreChange extends EventChange {
    public StoreChange(Store store){
        apply((StoreCreated event) ->{
            store.addressStore = event.getAddressStore();
            store.statusStore = event.getStatusStore();

        });
        apply((DepositCreated event) ->{
            new Deposit(event.EntityId(), event.getDepositCapacity());

        });

    }
}
