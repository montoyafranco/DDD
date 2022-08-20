package com.AgustinMontoya.desafio.ddd.sell.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientName;

public class ClientNameUpdated extends DomainEvent {
    private final ClientName clientName;

    public ClientNameUpdated(ClientName clientName){
        super("sofka.sell.clientnameupdated");

        this.clientName = clientName;
    }

    public ClientName getClientName() {
        return clientName;
    }
}
