package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.AgustinMontoya.desafio.ddd.sell.Sell;
import com.AgustinMontoya.desafio.ddd.sell.commands.AddClient;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientID;

public class CreateClientUseCase extends UseCase<RequestCommand<AddClient>, ResponseEvents> {


@Override
public void executeUseCase(RequestCommand<AddClient> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();
        var sale = Sell.from(command.getEntityID(),super.retrieveEvents(command.getEntityID().value()));
        sale.createClient(new ClientID(),command.getClientName(),command.getClientPhone());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));

        }
        }