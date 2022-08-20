package com.AgustinMontoya.desafio.ddd.store.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.store.values.StatusStore;
import com.AgustinMontoya.desafio.ddd.store.values.StoreID;

public class UpdateStatus extends Command {
    private StoreID storeID;
    private StatusStore statusStore;

    public UpdateStatus(StoreID storeID, StatusStore statusStore) {
        this.storeID = storeID;
        this.statusStore = statusStore;
    }

    public StoreID getStoreID() {
        return storeID;
    }

    public StatusStore getStatusStore() {
        return statusStore;
    }
}
