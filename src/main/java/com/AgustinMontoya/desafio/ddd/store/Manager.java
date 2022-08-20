package com.AgustinMontoya.desafio.ddd.store;

import co.com.sofka.domain.generic.Entity;
import com.AgustinMontoya.desafio.ddd.store.values.ManagerID;

public class Manager extends Entity<ManagerID> {
    public Manager(ManagerID entityId) {
        super(entityId);
    }
}
