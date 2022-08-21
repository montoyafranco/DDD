package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.AgustinMontoya.desafio.ddd.sell.commands.CreateSale;
import com.AgustinMontoya.desafio.ddd.sell.events.SaleCreated;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;
import com.AgustinMontoya.desafio.ddd.sell.values.Sale_Status;
import com.AgustinMontoya.desafio.ddd.store.commands.CreateStore;
import com.AgustinMontoya.desafio.ddd.store.events.StoreCreated;
import com.AgustinMontoya.desafio.ddd.store.values.AddressStore;
import com.AgustinMontoya.desafio.ddd.store.values.StatusStore;
import com.AgustinMontoya.desafio.ddd.store.values.StoreID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateStoreUseCaseTest {
    @Test

    public void CreateStoreUseCaseTest(){
        CreateStore command = new CreateStore(new StoreID("root"),new AddressStore("existir"),new StatusStore("abierto"));
       CreateStoreUseCase useCase = new CreateStoreUseCase();

        var events =  UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()  -> new IllegalArgumentException("Something went wrong"))
                .getDomainEvents();

        //asser

        StoreCreated event = (StoreCreated) events.get(0);
        Assertions.assertEquals(command.getStatusStore().value(), event.getStatusStore().value());
        Assertions.assertEquals(command.getEntityId().value(), event.aggregateRootId());

    }

}