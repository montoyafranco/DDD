package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.AgustinMontoya.desafio.ddd.store.commands.UpdateCapacity;
import com.AgustinMontoya.desafio.ddd.store.commands.UpdateMailManager;
import com.AgustinMontoya.desafio.ddd.store.events.*;
import com.AgustinMontoya.desafio.ddd.store.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UpdateDepositCapacityUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    public void testCapacityUpdate() {
        var useCase = new UpdateDepositCapacityUseCase();

        var event = new StoreCreated(new AddressStore("Agus"),new StatusStore("open"));
        event.setAggregateRootId("agus");
        var event1 = new DepositCreated(DepositID.of("agus"),new DepositCapacity("100"));

        //arrange
        var command = new UpdateCapacity(new DepositCapacity("60"), StoreID.of("agus"));
        Mockito.when(repository.getEventsBy("agus")).thenReturn(List.of(event,event1));
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getStoreID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
//assert
        var event2 = (CapacityUpdated)events.get(0);
        Assertions.assertEquals(command.getDepositCapacity(), event2.getDepositCapacity());
        Mockito.verify(repository).getEventsBy("agus");

    }

}