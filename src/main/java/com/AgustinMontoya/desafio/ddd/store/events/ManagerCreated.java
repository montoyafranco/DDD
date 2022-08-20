package com.AgustinMontoya.desafio.ddd.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.values.*;

public class ManagerCreated extends DomainEvent {
    private final ManagerID entityId;
    private final ManagerName managerName;
    private final ManagerMail managerMail;

    public ManagerCreated(ManagerID entityId, ManagerName managerName , ManagerMail managerMail ){
        super("sofka.store.managercreated");
        this.entityId = entityId;
        this.managerName = managerName;
        this.managerMail = managerMail;
    }

    public ManagerID getEntityId() {
        return entityId;
    }

    public ManagerName getManagerName() {
        return managerName;
    }

    public ManagerMail getManagerMail() {
        return managerMail;
    }
}
