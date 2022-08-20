package com.AgustinMontoya.desafio.ddd.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.values.ManagerMail;

public class ManagerMailUpdated extends DomainEvent {
    private ManagerMail managerMail;
    public ManagerMailUpdated( ManagerMail managerMail){
        super("sofka.store.managermailupdated");

        this.managerMail = managerMail;
    }

    public ManagerMail getManagerMail() {
        return managerMail;
    }
}
