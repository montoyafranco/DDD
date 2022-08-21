package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.commands.AddClient;
import com.AgustinMontoya.desafio.ddd.sell.commands.AddProduct;
import com.AgustinMontoya.desafio.ddd.sell.events.ClientCreated;
import com.AgustinMontoya.desafio.ddd.sell.events.ProductCreated;
import com.AgustinMontoya.desafio.ddd.sell.events.SaleCreated;
import com.AgustinMontoya.desafio.ddd.sell.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class CreateClientUseCaseTest {
    @InjectMocks
    private CreateClientUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void testProduct(){
        //arrange

        var command = new AddClient(new SaleID("hola"),new ClientPhone("4532"),new ClientName("Agus"));
        when(repository.getEventsBy("hola")).thenReturn(listOfEvents());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEntityID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ClientCreated)events.get(0);
        Assertions.assertEquals(command.getClientPhone(), event.getClientPhone());

    }

    private List<DomainEvent> listOfEvents() {
        Sale_Status status = new Sale_Status("abierto");
        var event = new SaleCreated(status);
        event.setAggregateRootId("agua");
        return List.of(event);
    }

}