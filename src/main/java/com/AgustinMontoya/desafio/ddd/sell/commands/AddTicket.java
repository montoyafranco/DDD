package com.AgustinMontoya.desafio.ddd.sell.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;
import com.AgustinMontoya.desafio.ddd.sell.values.TicketAmount;
import com.AgustinMontoya.desafio.ddd.sell.values.TicketID;
import com.AgustinMontoya.desafio.ddd.sell.values.TicketTimeStamp;

public class AddTicket extends Command {
    private SaleID entityId;
    private  TicketAmount ticketAmount;
    private  TicketTimeStamp ticketTimeStamp;

    public AddTicket(SaleID entityId, TicketAmount ticketAmount, TicketTimeStamp ticketTimeStamp) {
        this.entityId = entityId;
        this.ticketAmount = ticketAmount;
        this.ticketTimeStamp = ticketTimeStamp;
    }

    public SaleID getEntityId() {
        return entityId;
    }

    public TicketAmount getTicketAmount() {
        return ticketAmount;
    }

    public TicketTimeStamp getTicketTimeStamp() {
        return ticketTimeStamp;
    }
}
