package com.AgustinMontoya.desafio.ddd.sell.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientName;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;

public class UpdateNameClient extends Command {
    private ClientName clientName;
    private SaleID saleID;

    public UpdateNameClient(ClientName clientName, SaleID saleID) {
        this.clientName = clientName;
        this.saleID = saleID;
    }

    public ClientName getClientName() {
        return clientName;
    }

    public SaleID getSaleID() {
        return saleID;
    }
}
