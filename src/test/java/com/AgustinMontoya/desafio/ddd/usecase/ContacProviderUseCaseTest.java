package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.AgustinMontoya.desafio.ddd.store.events.DepositCreated;
import com.AgustinMontoya.desafio.ddd.store.events.OwnerCreated;
import com.AgustinMontoya.desafio.ddd.store.events.ProviderContacted;
import com.AgustinMontoya.desafio.ddd.store.values.DepositCapacity;
import com.AgustinMontoya.desafio.ddd.store.values.DepositID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ContacProviderUseCaseTest {

    private DomainEventRepository repository;

@Test
    void contactProviderTest(){
    var useCase = new ContacProviderUseCase();

    var domainEvent = new DepositCreated(new DepositID("hola"),new DepositCapacity("Call provider for stocks"));
    domainEvent.setAggregateRootId("hola");

    Mockito.when(repository.getEventsBy("hola")).thenReturn(List.of(domainEvent));
    useCase.addRepository(repository);

    var events = UseCaseHandler.getInstance()
            .syncExecutor(useCase, new TriggeredEvent<>(domainEvent))
            .orElseThrow()
            .getDomainEvents();

    var event1 = (ProviderContacted)events.get(0);
    Assertions.assertEquals(domainEvent.getDepositCapacity().value(),event1.getDepositCapacity());
    Mockito.verify(repository).getEventsBy("hola");








}
}