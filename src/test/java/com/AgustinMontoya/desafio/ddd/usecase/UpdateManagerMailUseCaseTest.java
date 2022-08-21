package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.commands.UpdateMailManager;
import com.AgustinMontoya.desafio.ddd.store.events.ManagerCreated;
import com.AgustinMontoya.desafio.ddd.store.events.ManagerMailUpdated;
import com.AgustinMontoya.desafio.ddd.store.events.StoreCreated;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateManagerMailUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void testManagerUpdate() {
        var useCase = new  UpdateManagerMailUseCase();

        var event = new StoreCreated(new AddressStore("Agus"),new StatusStore("open"));
        event.setAggregateRootId("agus");
        var event2 = new ManagerCreated(ManagerID.of("agus"),new ManagerName("agus"),new ManagerMail("lalo@gmail.com"));


    //arrange
    var command = new UpdateMailManager(new ManagerMail("agus@gmail.com"), StoreID.of("agus"));
        Mockito.when(repository.getEventsBy("agus")).thenReturn(List.of(event,event2));
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getStoreID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
//assert
        var event3 = (ManagerMailUpdated)events.get(0);
        Assertions.assertEquals(command.getManagerMail(), event3.getManagerMail());
        Mockito.verify(repository).getEventsBy("agus");

}


}