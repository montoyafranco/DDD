package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.commands.AddManager;
import com.AgustinMontoya.desafio.ddd.store.commands.AddOwner;
import com.AgustinMontoya.desafio.ddd.store.events.ManagerCreated;
import com.AgustinMontoya.desafio.ddd.store.events.OwnerCreated;
import com.AgustinMontoya.desafio.ddd.store.events.StoreCreated;
import com.AgustinMontoya.desafio.ddd.store.values.*;
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
class CreateOwnerUseCaseTest {


    @Mock
    private DomainEventRepository repository;

    @Test
    void TestAddOwner(){

        var useCase = new CreateOwnerUseCase();

        var event = new StoreCreated(new AddressStore("hola"),new StatusStore("hola"));
        event.setAggregateRootId("xxxx");
        //arrange


        var command = new AddOwner(new OwnerName("Agus"),new OwnerPhone("456"),new StoreID("41"));

        when(repository.getEventsBy("41")).thenReturn(List.of(event));
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getStoreID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event1 = (OwnerCreated)events.get(0);
        Assertions.assertEquals(command.getOwnerName(), event1.getOwnerName());

    }


}