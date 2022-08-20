package com.AgustinMontoya.desafio.ddd.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.values.AddressStore;
import com.AgustinMontoya.desafio.ddd.store.values.StatusStore;

public class StatusUpdated extends DomainEvent {
    private final StatusStore statusStore;

    public StatusUpdated(StatusStore statusStore) {
        super("sofka.store.addresupdated");
        this.statusStore = statusStore;
    }

    public StatusStore getStatusStore() {
        return statusStore;
    }
}
