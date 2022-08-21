package com.AgustinMontoya.desafio.ddd.store.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.store.values.*;

public class AddManager extends Command {
    private ManagerName managerName;
    private ManagerMail managerMail;
    private StoreID storeID;

    public AddManager(ManagerName managerName,     ManagerMail managerMail,    StoreID storeID){

        this.managerName = managerName;
        this.managerMail = managerMail;
        this.storeID = storeID;    }

    public ManagerName getManagerName() {
        return managerName;
    }
    public ManagerMail getManagerMail() {
        return managerMail;
    }
    public StoreID getStoreID() {
        return storeID;
    }
}
