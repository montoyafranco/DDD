package com.AgustinMontoya.desafio.ddd.sell.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ProductPrice implements ValueObject<String> {
    private final String valor;

    public ProductPrice(String valor) {
        this.valor = Objects.requireNonNull(valor);
    }

    @Override
    public String value() {
        return valor;
    }
}

