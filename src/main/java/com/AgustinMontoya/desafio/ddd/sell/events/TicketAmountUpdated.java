package com.AgustinMontoya.desafio.ddd.sell.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.values.TicketAmount;

public class TicketAmountUpdated extends DomainEvent {
    private final TicketAmount ticketAmount;

    public TicketAmountUpdated(TicketAmount ticketAmount){
        super("sofka.sell.ticketamountupdated");
        this.ticketAmount = ticketAmount;
    }

    public TicketAmount getTicketAmount() {
        return ticketAmount;
    }
}
