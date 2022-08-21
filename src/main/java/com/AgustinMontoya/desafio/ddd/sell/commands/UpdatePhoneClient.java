package com.AgustinMontoya.desafio.ddd.sell.commands;

import co.com.sofka.domain.generic.Command;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientPhone;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;

public class UpdatePhoneClient extends Command {
    private ClientPhone clientPhone;
    private SaleID saleID;

    public UpdatePhoneClient(ClientPhone clientPhone, SaleID saleID) {
        this.clientPhone = clientPhone;
        this.saleID = saleID;
    }

    public ClientPhone getClientPhone() {
        return clientPhone;
    }

    public SaleID getSaleID() {
        return saleID;
    }
}
