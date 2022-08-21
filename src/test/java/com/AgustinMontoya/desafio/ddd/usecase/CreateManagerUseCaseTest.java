package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.commands.AddManager;
import com.AgustinMontoya.desafio.ddd.store.events.ManagerCreated;
import com.AgustinMontoya.desafio.ddd.store.events.StoreCreated;
import com.AgustinMontoya.desafio.ddd.store.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateManagerUseCaseTest {
    @InjectMocks
    private CreateManagerUseCase UseCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void TestAddManager(){

        var event = new StoreCreated(new AddressStore("hola"),new StatusStore("hola"));
        event.setAggregateRootId("xxxx");
        //arrange
        StoreID storeID = StoreID.of("agus");
        ManagerName nombre = new ManagerName("Boss");
        ManagerMail managerMail = new ManagerMail("Boss");

        var command = new AddManager( nombre,managerMail, storeID);

        when(repository.getEventsBy("agus")).thenReturn(List.of(event));
        UseCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getStoreID().value())
                .syncExecutor(UseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event1 = (ManagerCreated)events.get(0);
        Assertions.assertEquals(command.getManagerName(), event1.getManagerName());

    }



}