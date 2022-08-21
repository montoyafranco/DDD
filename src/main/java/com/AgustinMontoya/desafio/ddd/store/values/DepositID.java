package com.AgustinMontoya.desafio.ddd.store.values;

import co.com.sofka.domain.generic.Identity;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientID;

public class DepositID extends Identity {
    public DepositID() {

    }
    public DepositID(String id){
        super(id);
    }
    public static DepositID of(String id){
        return new DepositID(id);
    }
}
