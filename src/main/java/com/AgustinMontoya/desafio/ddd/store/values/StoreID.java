package com.AgustinMontoya.desafio.ddd.store.values;

import co.com.sofka.domain.generic.Identity;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientID;

public class StoreID extends Identity {
    public StoreID() {

    }
    public StoreID(String id){
        super(id);
    }
    public static StoreID of(String id){
        return new StoreID(id);
    }
}
