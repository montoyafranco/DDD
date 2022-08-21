package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.AgustinMontoya.desafio.ddd.sell.Sell;
import com.AgustinMontoya.desafio.ddd.sell.commands.CreateSale;


public class CreateSellUseCase extends UseCase<RequestCommand<CreateSale>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CreateSale> createSaleRequestCommand) {
        var command = createSaleRequestCommand.getCommand();

        var sale = new Sell(command.getSaleID(),command.getSale_status());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));

    }



}
