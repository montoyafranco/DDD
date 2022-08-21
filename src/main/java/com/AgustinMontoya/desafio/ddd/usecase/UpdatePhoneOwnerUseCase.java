package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.AgustinMontoya.desafio.ddd.store.Store;
import com.AgustinMontoya.desafio.ddd.store.commands.UpdateMailManager;
import com.AgustinMontoya.desafio.ddd.store.commands.UpdatePhoneOwner;
import com.AgustinMontoya.desafio.ddd.store.events.UpdatedPhoneOwner;

public class UpdatePhoneOwnerUseCase extends UseCase<RequestCommand<UpdatePhoneOwner>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdatePhoneOwner> updatedPhoneOwnerRequestCommand) {
        var command = updatedPhoneOwnerRequestCommand.getCommand();
        var store = Store.from(command.getStoreID(),super.retrieveEvents(command.getStoreID().value()));
        store.updatePhoneOwner( command.getOwnerPhone());
        emit().onResponse(new ResponseEvents(store.getUncommittedChanges()));
    }
}
