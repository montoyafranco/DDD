package com.AgustinMontoya.desafio.ddd.sell.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientPhone;

public class ClientPhoneUpdated extends DomainEvent {
    private final ClientPhone clientPhone;

    public ClientPhoneUpdated(ClientPhone clientPhone){
        super("sofka.sale.clientphoneupdated");

        this.clientPhone = clientPhone;
    }

    public ClientPhone getClientPhone() {
        return clientPhone;
    }
}
