package com.AgustinMontoya.desafio.ddd.store.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DepositCapacity implements ValueObject<String> {
    private final String valor;

    public DepositCapacity(String valor) {
        this.valor = Objects.requireNonNull(valor);
    }

    @Override
    public String value() {
        return valor;
    }
}
