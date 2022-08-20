package com.AgustinMontoya.desafio.ddd.sell.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.values.TicketAmount;
import com.AgustinMontoya.desafio.ddd.sell.values.TicketID;
import com.AgustinMontoya.desafio.ddd.sell.values.TicketTimeStamp;

public class TicketCreated extends DomainEvent {
    private final TicketID entityId;
    private final TicketAmount ticketAmount;
    private final TicketTimeStamp ticketTimeStamp;

    public TicketCreated(TicketID entityId, TicketAmount ticketAmount , TicketTimeStamp ticketTimeStamp){
        super("sofka.sell.ticketcreated");
        this.entityId = entityId;
        this.ticketAmount = ticketAmount;
        this.ticketTimeStamp = ticketTimeStamp;
    }

    public TicketID getEntityId() {
        return entityId;
    }

    public TicketAmount getTicketAmount() {
        return ticketAmount;
    }

    public TicketTimeStamp getTicketTimeStamp() {
        return ticketTimeStamp;
    }
}
