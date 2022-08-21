package com.AgustinMontoya.desafio.ddd.sell.values;

import co.com.sofka.domain.generic.Identity;

public class TicketID extends Identity {
    public TicketID() {

    }
    public TicketID(String id){
        super(id);
    }
    public static TicketID of(String id){
        return new TicketID(id);
    }
}
