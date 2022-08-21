package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.AgustinMontoya.desafio.ddd.store.Store;
import com.AgustinMontoya.desafio.ddd.store.commands.UpdateMailManager;

public class UpdateManagerMailUseCase extends UseCase<RequestCommand<UpdateMailManager>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateMailManager> updateMailManagerRequestCommand) {
        var command = updateMailManagerRequestCommand.getCommand();
        var store = Store.from(command.getStoreID(),super.retrieveEvents(command.getStoreID().value()));
        store.updateMailManager( command.getManagerMail());
        emit().onResponse(new ResponseEvents(store.getUncommittedChanges()));
    }
}