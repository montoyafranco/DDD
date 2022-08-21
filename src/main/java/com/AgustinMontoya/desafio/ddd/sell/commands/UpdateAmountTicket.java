package com.AgustinMontoya.desafio.ddd.sell.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;
import com.AgustinMontoya.desafio.ddd.sell.values.TicketAmount;

public class UpdateAmountTicket extends Command {
    private TicketAmount ticketAmount;
    private SaleID saleID;

    public UpdateAmountTicket(TicketAmount ticketAmount, SaleID saleID) {
        this.ticketAmount = ticketAmount;
        this.saleID = saleID;
    }

    public TicketAmount getTicketAmount() {
        return ticketAmount;
    }

    public SaleID getSaleID() {
        return saleID;
    }

}
