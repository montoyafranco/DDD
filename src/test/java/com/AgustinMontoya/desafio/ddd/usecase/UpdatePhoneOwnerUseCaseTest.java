package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.AgustinMontoya.desafio.ddd.store.commands.UpdateMailManager;
import com.AgustinMontoya.desafio.ddd.store.commands.UpdatePhoneOwner;
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
class UpdatePhoneOwnerUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void testOwnerPhoneUpdate() {
        var useCase = new UpdatePhoneOwnerUseCase();

        var event = new StoreCreated(new AddressStore("Agus"),new StatusStore("open"));
        event.setAggregateRootId("agus");
        var event2 = new OwnerCreated(OwnerID.of("agus"),new OwnerName("agus"),new OwnerPhone("3513592220"));


        //arrange
        var command = new UpdatePhoneOwner(new OwnerPhone("57351359"),StoreID.of("agus"));
        Mockito.when(repository.getEventsBy("agus")).thenReturn(List.of(event,event2));
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getStoreID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
//assert
        var event3 = (UpdatedPhoneOwner)events.get(0);
        Assertions.assertEquals(command.getOwnerPhone(), event3.getOwnerPhone());
        Mockito.verify(repository).getEventsBy("agus");

    }

}