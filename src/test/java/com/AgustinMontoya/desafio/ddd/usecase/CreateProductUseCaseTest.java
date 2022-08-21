package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.commands.AddProduct;
import com.AgustinMontoya.desafio.ddd.sell.events.ProductCreated;
import com.AgustinMontoya.desafio.ddd.sell.events.SaleCreated;
import com.AgustinMontoya.desafio.ddd.sell.values.ProductName;
import com.AgustinMontoya.desafio.ddd.sell.values.ProductPrice;
import com.AgustinMontoya.desafio.ddd.sell.values.SaleID;
import com.AgustinMontoya.desafio.ddd.sell.values.Sale_Status;
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
class CreateProductUseCaseTest {
    @InjectMocks
    private CreateProductUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void testProduct(){
        //arrange

        var command = new AddProduct(new SaleID("agua"), new ProductName("agua"),  new ProductPrice("agua"));

        when(repository.getEventsBy("agua")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEntityId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ProductCreated)events.get(0);
        Assertions.assertEquals("agua", event.getProductName().value());

    }

    private List<DomainEvent> history() {
        Sale_Status status = new Sale_Status("abierto");
        var event = new SaleCreated(status);
        event.setAggregateRootId("agua");
        return List.of(event);
    }
}