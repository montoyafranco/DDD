package com.AgustinMontoya.desafio.ddd.store;

import co.com.sofka.domain.generic.Entity;
import com.AgustinMontoya.desafio.ddd.store.values.ManagerID;
import com.AgustinMontoya.desafio.ddd.store.values.ManagerMail;
import com.AgustinMontoya.desafio.ddd.store.values.ManagerName;

import java.util.Objects;

public class Manager extends Entity<ManagerID> {
    private  ManagerName managerName;
    private  ManagerMail managerMail;

    public Manager(ManagerID entityId, ManagerName managerName , ManagerMail managerMail) {
        super(entityId);
        this.managerName = managerName;
        this.managerMail = managerMail;
    }
    public void updateMailManager(ManagerMail managerMail){
        this.managerMail = Objects.requireNonNull(managerMail);

    }

    public void contactManager() {

    }

    public ManagerName ManagerName() {
        return managerName;
    }

    public ManagerMail ManagerMail() {
        return managerMail;
    }
}
