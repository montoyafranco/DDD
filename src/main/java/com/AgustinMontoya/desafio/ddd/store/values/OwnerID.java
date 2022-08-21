package com.AgustinMontoya.desafio.ddd.store.values;

import co.com.sofka.domain.generic.Identity;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientID;
import com.AgustinMontoya.desafio.ddd.store.Owner;

public class OwnerID extends Identity {
    public OwnerID() {

    }
    public OwnerID(String id){
        super(id);
    }
    public static OwnerID of(String id){
        return new OwnerID(id);
    }
}
