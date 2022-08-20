package com.AgustinMontoya.desafio.ddd.sell.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientID;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientName;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientPhone;

public class ClientCreated extends DomainEvent {

    private final ClientID entityID;
    private final ClientPhone clientPhone;
    private final ClientName clientName;

    public ClientCreated(ClientID entityID, ClientName clientName,ClientPhone clientPhone ){
        super("sofka.sell.clientcreated");

        this.entityID = entityID;
        this.clientPhone = clientPhone;
        this.clientName = clientName;
    }

    public ClientID getEntityID() {
        return entityID;
    }

    public ClientPhone getClientPhone() {
        return clientPhone;
    }

    public ClientName getClientName() {
        return clientName;
    }
}
