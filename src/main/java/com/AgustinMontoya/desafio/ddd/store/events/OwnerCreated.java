package com.AgustinMontoya.desafio.ddd.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.values.*;

public class OwnerCreated extends DomainEvent {
    private final OwnerID entityId;
    private final OwnerName ownerName;
    private final OwnerPhone ownerPhone;



    public OwnerCreated(OwnerID entityId, OwnerName ownerName, OwnerPhone ownerPhone ){
        super("sofka.store.ownercreated");
        this.entityId = entityId;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
    }
    public OwnerID getEntityId() {
        return entityId;
    }

    public OwnerName getOwnerName() {
        return ownerName;
    }

    public OwnerPhone getOwnerPhone() {
        return ownerPhone;
    }
}
