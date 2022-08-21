package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.AgustinMontoya.desafio.ddd.sell.Sell;
import com.AgustinMontoya.desafio.ddd.sell.commands.CumpleMetasVentas;

public class UpdateCumpleSalesQuantityUseCase extends UseCase<RequestCommand<CumpleMetasVentas>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CumpleMetasVentas> cumpleMetasVentasRequestCommand) {
        var command = cumpleMetasVentasRequestCommand.getCommand();
        var sell = Sell.from(command.getSaleID(),super.retrieveEvents(command.getSaleID().value()));
        sell.cumpleMetasVentas( command.getSellerSalesQuantity());
        emit().onResponse(new ResponseEvents(sell.getUncommittedChanges()));
    }
}
