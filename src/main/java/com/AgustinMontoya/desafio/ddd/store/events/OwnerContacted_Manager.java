package com.AgustinMontoya.desafio.ddd.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.values.ManagerMail;

public class OwnerContacted_Manager extends DomainEvent {
    private ManagerMail managerMail;
    public OwnerContacted_Manager( ManagerMail managerMail){
        super("sofka.store.ownercontactedmanager");

        this.managerMail = managerMail;
    }

    public ManagerMail getManagerMail() {
        return managerMail;
    }
}
