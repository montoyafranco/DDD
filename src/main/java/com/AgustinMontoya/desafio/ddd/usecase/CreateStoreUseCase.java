package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.AgustinMontoya.desafio.ddd.sell.Sell;
import com.AgustinMontoya.desafio.ddd.sell.commands.CreateSale;
import com.AgustinMontoya.desafio.ddd.store.Store;
import com.AgustinMontoya.desafio.ddd.store.commands.CreateStore;

public class CreateStoreUseCase  extends UseCase<RequestCommand<CreateStore>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CreateStore> createStoreRequestCommand) {
        var command = createStoreRequestCommand.getCommand();

        var sale = new Store(command.getEntityId(),command.getAddressStore(),command.getStatusStore());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));

    }



}
