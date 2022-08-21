package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.AgustinMontoya.desafio.ddd.store.Store;
import com.AgustinMontoya.desafio.ddd.store.commands.AddManager;
import com.AgustinMontoya.desafio.ddd.store.values.ManagerID;

public class CreateManagerUseCase extends UseCase<RequestCommand<AddManager>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddManager> addManagerRequestCommand) {
        var command = addManagerRequestCommand.getCommand();
        var store = Store.from(command.getStoreID(),super.retrieveEvents(command.getStoreID().value()));
        store.createManager(new ManagerID(),command.getManagerName(),command.getManagerMail());
        emit().onResponse(new ResponseEvents(store.getUncommittedChanges()));

    }
}
