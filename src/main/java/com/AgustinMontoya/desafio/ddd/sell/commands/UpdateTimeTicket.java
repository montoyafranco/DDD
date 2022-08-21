package com.AgustinMontoya.desafio.ddd.sell.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;
import com.AgustinMontoya.desafio.ddd.sell.values.TicketTimeStamp;

public class UpdateTimeTicket extends Command {
    private TicketTimeStamp ticketTimeStamp;
    private SaleID saleID;

    public UpdateTimeTicket(TicketTimeStamp ticketTimeStamp, SaleID saleID) {
        this.ticketTimeStamp = ticketTimeStamp;
        this.saleID = saleID;
    }

    public TicketTimeStamp getTicketTimeStamp() {
        return ticketTimeStamp;
    }

    public SaleID getSaleID() {
        return saleID;
    }
}
