package com.AgustinMontoya.desafio.ddd.store.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.store.values.ManagerMail;
import com.AgustinMontoya.desafio.ddd.store.values.StoreID;

public class UpdateMailManager extends Command {
    private ManagerMail managerMail;
    private StoreID storeID;

    public UpdateMailManager(ManagerMail managerMail, StoreID storeID) {
        this.managerMail = managerMail;
        this.storeID = storeID;
    }

    public ManagerMail getManagerMail() {
        return managerMail;
    }

    public StoreID getStoreID() {
        return storeID;
    }
}
