package com.AgustinMontoya.desafio.ddd.sell;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.sell.events.*;
import com.AgustinMontoya.desafio.ddd.sell.values.*;
import com.AgustinMontoya.desafio.ddd.store.events.OwnerCreated;
import com.AgustinMontoya.desafio.ddd.store.values.OwnerID;
import com.AgustinMontoya.desafio.ddd.store.values.OwnerName;
import com.AgustinMontoya.desafio.ddd.store.values.OwnerPhone;

import java.util.List;
import java.util.Objects;

public class Sell extends AggregateEvent<SaleID> {
    protected Sale_Status sale_status;
    protected Client client ;
    protected Product product;
    protected Seller seller;
    protected Ticket ticket;


    public Sell(SaleID entityId , Sale_Status sale_status) {
        super(entityId);
        appendChange(new SaleCreated(sale_status)).apply();
//        subscribe(new SellChange(this));
    }
    //cosntructor privado
    private Sell(SaleID saleID){
        super(saleID);
        subscribe(new SellChange(this));
    }
    //si ya tengo
    public static Sell from(SaleID saleID, List<DomainEvent> events){
        var sell = new Sell(saleID);
        events.forEach(sell::applyEvent);
        return sell;
    }
    public void createClient(ClientID entityId, ClientName clientName , ClientPhone clientPhone){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(clientName);
        Objects.requireNonNull(clientPhone);
        appendChange(new ClientCreated(entityId, clientName, clientPhone)).apply();
    }
    public void createProduct(ProductID productID ,ProductName productName, ProductPrice productPrice){

        Objects.requireNonNull(productName);
        Objects.requireNonNull(productPrice);
        appendChange(new ProductCreated(productID, productName, productPrice)).apply();
    }
    public void createSeller(SellerID entityId, SellerName sellerName , SellerSalesQuantity sellerSalesQuantity){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(sellerName);
        Objects.requireNonNull(sellerSalesQuantity);
        appendChange(new SellerCreated(entityId, sellerName, sellerSalesQuantity)).apply();
    }
    public void createTicket(TicketID entityId, TicketAmount ticketAmount , TicketTimeStamp ticketTimeStamp){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(ticketAmount);
        Objects.requireNonNull(ticketTimeStamp);
        appendChange(new TicketCreated(entityId, ticketAmount, ticketTimeStamp)).apply();
    }
    public void statusUpdate( Sale_Status sale_status){
        Objects.requireNonNull(sale_status);
        appendChange(new StatusUpdated(sale_status)).apply();

    }
    public void cumpleMetasVentas(SellerSalesQuantity sellerSalesQuantity){
        Objects.requireNonNull(sellerSalesQuantity);
        appendChange(new ChequeadoMetasVentas(sellerSalesQuantity)).apply();
    }
    public void updateSellerName(SellerName sellerName){
        Objects.requireNonNull(sellerName);
        appendChange(new SellerNameUpdated(sellerName)).apply();

    }

    public void updateClientName(ClientName clientName){
        Objects.requireNonNull(clientName);
        appendChange(new ClientNameUpdated(clientName)).apply();
    }
    public void updateClientPhone(ClientPhone clientPhone){
        Objects.requireNonNull(clientPhone);
        appendChange(new ClientPhoneUpdated(clientPhone)).apply();
    }
    public void updateProductName(ProductName productName){
        Objects.requireNonNull(productName);
        appendChange(new ProductNameUpdated(productName)).apply();
    }
    public void updateProductPrice(ProductPrice productPrice){
        Objects.requireNonNull(productPrice);
        appendChange(new ProductPriceUpdated(productPrice)).apply();
    }
    public void updateAmountTicket(TicketAmount ticketAmount){
        Objects.requireNonNull(ticketAmount);
        appendChange(new TicketAmountUpdated(ticketAmount)).apply();

    }
    public void updateTimeTicket(TicketTimeStamp ticketTimeStamp){
        Objects.requireNonNull(ticketTimeStamp);
        appendChange(new TicketTimeUpdated(ticketTimeStamp)).apply();
    }

    public Sale_Status sale_status() {
        return sale_status;
    }

    public Client client() {
        return client;
    }

    public Product product() {
        return product;
    }

    public Seller seller() {
        return seller;
    }

    public Ticket ticket() {
        return ticket;
    }
}
