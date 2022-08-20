package com.AgustinMontoya.desafio.ddd.sell.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.values.Sale_Status;

public class StatusUpdated extends DomainEvent {
    private final Sale_Status sale_status;

    public StatusUpdated(Sale_Status sale_status){
        super("sofka.sell.statusupdated");

        this.sale_status = sale_status;
    }

    public Sale_Status getSale_status() {
        return sale_status;
    }
}
