package com.AgustinMontoya.desafio.ddd.sell.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.values.TicketTimeStamp;

public class TicketTimeUpdated extends DomainEvent {
    private final TicketTimeStamp ticketTimeStamp;

    public TicketTimeUpdated(TicketTimeStamp ticketTimeStamp){
        super("sofka.sell.tickettimeupdated");
        this.ticketTimeStamp = ticketTimeStamp;
    }

    public TicketTimeStamp getTicketTimeStamp() {
        return ticketTimeStamp;
    }
}
