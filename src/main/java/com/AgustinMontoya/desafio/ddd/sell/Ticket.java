package com.AgustinMontoya.desafio.ddd.sell;

import co.com.sofka.domain.generic.Entity;
import com.AgustinMontoya.desafio.ddd.sell.values.*;

import java.util.Objects;

public class Ticket extends Entity<TicketID> {

    protected TicketAmount ticketAmount;
    protected TicketTimeStamp ticketTimeStamp;

    public Ticket(TicketID entityId, TicketAmount ticketAmount , TicketTimeStamp ticketTimeStamp) {
        super(entityId);
        this.ticketAmount = ticketAmount;
        this.ticketTimeStamp = ticketTimeStamp;
    }
    //comportamientos
    public void updateAmountTicket(TicketAmount ticketAmount){
        this.ticketAmount = Objects.requireNonNull(ticketAmount);

    }
    public void updateTimeTicket(TicketTimeStamp ticketTimeStamp){
        this.ticketTimeStamp = Objects.requireNonNull(ticketTimeStamp);
    }

    public TicketAmount ticketAmount() {
        return ticketAmount;
    }

    public TicketTimeStamp ticketTimeStamp() {
        return ticketTimeStamp;
    }
}
