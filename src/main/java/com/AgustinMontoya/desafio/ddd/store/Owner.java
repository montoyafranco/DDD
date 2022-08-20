package com.AgustinMontoya.desafio.ddd.store;

import co.com.sofka.domain.generic.Entity;
import com.AgustinMontoya.desafio.ddd.store.values.OwnerID;
import com.AgustinMontoya.desafio.ddd.store.values.OwnerName;
import com.AgustinMontoya.desafio.ddd.store.values.OwnerPhone;

import java.util.Objects;

public class Owner extends Entity<OwnerID> {
    protected OwnerName ownerName;
    protected OwnerPhone ownerPhone;

    public Owner(OwnerID entityId, OwnerName ownerName, OwnerPhone ownerPhone) {
        super(entityId);


        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
    }

    public OwnerName ownerName() {
        return ownerName;
    }

    public OwnerPhone ownerPhone() {
        return ownerPhone;
    }

    public void updatePhoneOwner(OwnerPhone ownerPhone){
        this.ownerPhone = Objects.requireNonNull(ownerPhone);
    }


}
