package com.AgustinMontoya.desafio.ddd.store.values;

import co.com.sofka.domain.generic.ValueObject;

public class OwnerName implements ValueObject<String> {
    private final String value;

    public OwnerName(String value) {
        this.value = value;
    }

    public String value(){
        return value;
    }
}
