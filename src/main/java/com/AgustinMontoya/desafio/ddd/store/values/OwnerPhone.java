package com.AgustinMontoya.desafio.ddd.store.values;

import co.com.sofka.domain.generic.ValueObject;

public class OwnerPhone implements ValueObject<String> {
    private final String value;

    public OwnerPhone(String value) {
        this.value = value;
    }

    public String value(){
        return value;
    }
}
