package com.AgustinMontoya.desafio.ddd.store;

import co.com.sofka.domain.generic.Entity;
import com.AgustinMontoya.desafio.ddd.store.values.OwnerID;

public class Owner extends Entity<OwnerID> {
    public Owner(OwnerID entityId) {
        super(entityId);
    }
}
