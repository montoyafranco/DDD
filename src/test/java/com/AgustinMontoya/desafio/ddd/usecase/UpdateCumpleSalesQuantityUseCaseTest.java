package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.AgustinMontoya.desafio.ddd.sell.commands.CumpleMetasVentas;
import com.AgustinMontoya.desafio.ddd.sell.events.ChequeadoMetasVentas;
import com.AgustinMontoya.desafio.ddd.sell.events.SaleCreated;
import com.AgustinMontoya.desafio.ddd.sell.events.SellerCreated;
import com.AgustinMontoya.desafio.ddd.sell.values.*;
import com.AgustinMontoya.desafio.ddd.store.commands.UpdateCapacity;
import com.AgustinMontoya.desafio.ddd.store.events.CapacityUpdated;
import com.AgustinMontoya.desafio.ddd.store.events.DepositCreated;
import com.AgustinMontoya.desafio.ddd.store.events.StoreCreated;
import com.AgustinMontoya.desafio.ddd.store.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UpdateCumpleSalesQuantityUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    public void testQuantitySales() {
        var useCase = new UpdateCumpleSalesQuantityUseCase();

        var event = new SaleCreated(new Sale_Status("Aprobada"));
        event.setAggregateRootId("agus");
        var event1 = new SellerCreated( SellerID.of("agus"),new SellerName("fede"),new SellerSalesQuantity("5"));


        //arrange
        var command = new CumpleMetasVentas(new SellerSalesQuantity("10"), SaleID.of("agus"));
        Mockito.when(repository.getEventsBy("agus")).thenReturn(List.of(event,event1));
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSaleID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
//assert
        var event2 = (ChequeadoMetasVentas)events.get(0);
        Assertions.assertEquals(command.getSellerSalesQuantity(), event2.getSellerSalesQuantity());
        Mockito.verify(repository).getEventsBy("agus");

    }

}