package com.AgustinMontoya.desafio.ddd.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.values.DepositCapacity;
import com.AgustinMontoya.desafio.ddd.store.values.DepositID;
import com.AgustinMontoya.desafio.ddd.store.values.StoreID;

public class DepositCreated extends DomainEvent {
    private final DepositID entityId;
    private final DepositCapacity depositCapacity;

    public DepositCreated(DepositID entityId, DepositCapacity depositCapacity ){
        super("sofka.store.depositcreated");
        this.entityId = entityId;
        this.depositCapacity = depositCapacity;
    }

    public DepositID EntityId() {
        return entityId;
    }

    public DepositCapacity getDepositCapacity() {
        return depositCapacity;
    }
}
