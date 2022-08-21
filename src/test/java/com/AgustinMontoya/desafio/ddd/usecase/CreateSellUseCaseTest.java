package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.commands.CreateSale;
import com.AgustinMontoya.desafio.ddd.sell.events.SaleCreated;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;
import com.AgustinMontoya.desafio.ddd.sell.values.Sale_Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CreateSellUseCaseTest {
//    private CreateSellUseCase useCase;
    @Test
    public void CreateSellUseCaseTest(){
        CreateSale command = new CreateSale(new Sale_Status("hola"),new SaleID("idFuerte"));
        CreateSellUseCase useCase = new CreateSellUseCase();

        var events =  UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()  -> new IllegalArgumentException("Something went wrong"))
                .getDomainEvents();

        //asser

        SaleCreated event = (SaleCreated)events.get(0);
        Assertions.assertEquals(command.getSale_status().value(), event.getSale_status().value());
        Assertions.assertEquals(command.getSaleID().value(), event.aggregateRootId());

    }


}