package com.AgustinMontoya.desafio.ddd.sell;

import co.com.sofka.domain.generic.EventChange;
import com.AgustinMontoya.desafio.ddd.sell.events.*;

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
            sell.seller.sellerName = event.getSellerName();
            sell.seller.sellerSalesQuantity = event.getSellerSalesQuantity();
        });
        apply((TicketCreated event) ->{
            sell.ticket.ticketAmount = event.getTicketAmount();
            sell.ticket.ticketTimeStamp = event.getTicketTimeStamp();
        });




    }
}
