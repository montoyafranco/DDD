package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.AgustinMontoya.desafio.ddd.store.Store;
import com.AgustinMontoya.desafio.ddd.store.commands.AddManager;
import com.AgustinMontoya.desafio.ddd.store.commands.AddOwner;
import com.AgustinMontoya.desafio.ddd.store.values.ManagerID;
import com.AgustinMontoya.desafio.ddd.store.values.OwnerID;

public class CreateOwnerUseCase extends UseCase<RequestCommand<AddOwner>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddOwner> addOwnerRequestCommand) {
        var command = addOwnerRequestCommand.getCommand();
        var store = Store.from(command.getStoreID(),super.retrieveEvents(command.getStoreID().value()));
        store.createOwner(new OwnerID(), command.getOwnerName(), command.getOwnerPhone());
        emit().onResponse(new ResponseEvents(store.getUncommittedChanges()));

    }
}
