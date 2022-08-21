package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.AgustinMontoya.desafio.ddd.store.Store;
import com.AgustinMontoya.desafio.ddd.store.events.DepositCreated;
import com.AgustinMontoya.desafio.ddd.store.values.DepositCapacity;
import com.AgustinMontoya.desafio.ddd.store.values.StoreID;

public class ContacProviderUseCase extends UseCase<TriggeredEvent<DepositCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<DepositCreated> depositCreatedTriggeredEvent) {
        var event = depositCreatedTriggeredEvent.getDomainEvent();
        var store = Store.from(StoreID.of(event.aggregateRootId()),this.retrieveEvents());

        store.contactProvider(new DepositCapacity("Call provider for stocks"));

        emit().onResponse(new ResponseEvents(store.getUncommittedChanges()));




    }
}
