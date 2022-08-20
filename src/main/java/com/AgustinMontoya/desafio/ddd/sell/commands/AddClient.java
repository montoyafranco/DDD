package com.AgustinMontoya.desafio.ddd.sell.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientID;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientName;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientPhone;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;

public class AddClient extends Command {
    private  SaleID entityID;
    private  ClientPhone clientPhone;
    private  ClientName clientName;

    public AddClient(SaleID entityID, ClientPhone clientPhone, ClientName clientName) {
        this.entityID = entityID;
        this.clientPhone = clientPhone;
        this.clientName = clientName;
    }

    public SaleID getEntityID() {
        return entityID;
    }

    public ClientPhone getClientPhone() {
        return clientPhone;
    }

    public ClientName getClientName() {
        return clientName;
    }
}
