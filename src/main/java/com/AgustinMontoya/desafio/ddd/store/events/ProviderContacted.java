package com.AgustinMontoya.desafio.ddd.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.values.DepositCapacity;

public class ProviderContacted extends DomainEvent {
    private final DepositCapacity depositCapacity;

    public ProviderContacted(DepositCapacity depositCapacity) {
        super("sofka.store.providercontacted");
        this.depositCapacity = depositCapacity;
    }

    public DepositCapacity getDepositCapacity() {
        return depositCapacity;
    }}
