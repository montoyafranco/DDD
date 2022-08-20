package com.AgustinMontoya.desafio.ddd.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.values.OwnerPhone;

public class UpdatedPhoneOwner extends DomainEvent {
    private final OwnerPhone ownerPhone;

    public UpdatedPhoneOwner(OwnerPhone ownerPhone) {
        super("sofka.store.updatedphoneowner");
        this.ownerPhone = ownerPhone;
    }

    public OwnerPhone getOwnerPhone() {
        return ownerPhone;
    }
}
