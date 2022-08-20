package com.AgustinMontoya.desafio.ddd.sell;

import co.com.sofka.domain.generic.Entity;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientID;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientName;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientPhone;

import java.util.Objects;

public class Client extends Entity<ClientID> {

    private  ClientName clientName;
    private  ClientPhone clientPhone;

    public Client(ClientID entityId, ClientName clientName , ClientPhone clientPhone) {
        super(entityId);
        this.clientName = clientName;
        this.clientPhone = clientPhone;
    }
    //comportamiento
    public void updateClientName(ClientName clientName){
        this.clientName = Objects.requireNonNull(clientName);

    }
    public void updateClientPhone(ClientPhone clientPhone){
        this.clientPhone = Objects.requireNonNull(clientPhone);
    }


    public ClientName clientName() {
        return clientName;
    }

    public ClientPhone clientPhone() {
        return clientPhone;
    }
}
