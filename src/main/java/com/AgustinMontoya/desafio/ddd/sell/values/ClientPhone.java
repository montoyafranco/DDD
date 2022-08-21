package com.AgustinMontoya.desafio.ddd.sell.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ClientPhone implements ValueObject<String> {
    private final String valor;

    public ClientPhone(String valor) {
        this.valor = Objects.requireNonNull(valor);
    }

    @Override
    public String value() {
        return valor;
    }
}

