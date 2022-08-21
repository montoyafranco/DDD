package com.AgustinMontoya.desafio.ddd.sell;

import co.com.sofka.domain.generic.EventChange;
import com.AgustinMontoya.desafio.ddd.sell.commands.UpdateNameClient;
import com.AgustinMontoya.desafio.ddd.sell.events.*;
import com.AgustinMontoya.desafio.ddd.sell.values.ClientPhone;

public class SellChange extends EventChange {
    public SellChange(Sell sell){
        apply((SaleCreated event)->{
            sell.sale_status = event.getSale_status();

        });
        apply((ClientCreated event) ->{
            sell.client = new Client(event.getEntityID(),event.getClientName(),event.getClientPhone());
        });
        apply((ProductCreated event) ->{
            sell.product = new Product(event.getEntityId(),event.getProductName(),event.getProductPrice());
        });
        apply((SellerCreated event) ->{
            sell.seller = new Seller(event.getEntityId(),event.getSellerName(),event.getSellerSalesQuantity());
        });
        apply((TicketCreated event) ->{
            sell.ticket.ticketAmount = event.getTicketAmount();
            sell.ticket.ticketTimeStamp = event.getTicketTimeStamp();
        });
        apply((ChequeadoMetasVentas event) ->{
            sell.seller.sellerSalesQuantity = event.getSellerSalesQuantity();
        });
        apply((ClientNameUpdated event) ->{
            sell.client.clientName= event.getClientName();
        });
        apply((ClientPhoneUpdated event) ->{
            sell.client.clientPhone= event.getClientPhone();
        });
        apply((ProductNameUpdated event) ->{
            sell.product.productName= event.getProductName();
        });
        apply((ProductNameUpdated event) ->{
            sell.product.productName= event.getProductName();
        });
        apply((SellerNameUpdated event) ->{
            sell.seller.sellerName= event.getSellerName();
        });
        apply((TicketTimeUpdated event) ->{
            sell.ticket.ticketTimeStamp= event.getTicketTimeStamp();
        });
        apply((TicketAmountUpdated event) ->{
            sell.ticket.ticketAmount= event.getTicketAmount();
        });





    }
}
