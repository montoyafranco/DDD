package com.AgustinMontoya.desafio.ddd.store.values;

import co.com.sofka.domain.generic.Identity;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientID;

public class ManagerID extends Identity {
    public ManagerID() {

    }
    public ManagerID(String id){
        super(id);
    }
    public static ManagerID of(String id){
        return new ManagerID(id);
    }
}
