package com.AgustinMontoya.desafio.ddd.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.values.OwnerPhone;

public class SallariedPayed extends DomainEvent {
    private final OwnerPhone ownerPhone;

    public SallariedPayed(OwnerPhone ownerPhone) {
        super("sofka.store.sallariedpayed");
        this.ownerPhone = ownerPhone;
    }

    public OwnerPhone getOwnerPhone() {
        return ownerPhone;
    }
}
