package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.AgustinMontoya.desafio.ddd.store.Store;
import com.AgustinMontoya.desafio.ddd.store.commands.UpdateCapacity;
import com.AgustinMontoya.desafio.ddd.store.commands.UpdateMailManager;

public class UpdateDepositCapacityUseCase extends UseCase<RequestCommand<UpdateCapacity>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateCapacity> updateCapacityRequestCommand) {
        var command = updateCapacityRequestCommand.getCommand();
        var store = Store.from(command.getStoreID(),super.retrieveEvents(command.getStoreID().value()));
        store.updateCapacity( command.getDepositCapacity());
        emit().onResponse(new ResponseEvents(store.getUncommittedChanges()));
    }
}
