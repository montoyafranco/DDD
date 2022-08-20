package com.AgustinMontoya.desafio.ddd.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.values.DepositCapacity;

public class CapacityUpdated extends DomainEvent {
    private final DepositCapacity depositCapacity;

    public CapacityUpdated(DepositCapacity depositCapacity) {
        super("sofka.store.capacityupdated");
        this.depositCapacity = depositCapacity;
    }

    public DepositCapacity getDepositCapacity() {
        return depositCapacity;
    }
}
