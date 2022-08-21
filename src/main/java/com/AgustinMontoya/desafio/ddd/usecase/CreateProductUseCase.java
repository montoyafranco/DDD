package com.AgustinMontoya.desafio.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.AgustinMontoya.desafio.ddd.sell.Product;
import com.AgustinMontoya.desafio.ddd.sell.Sell;
import com.AgustinMontoya.desafio.ddd.sell.commands.AddProduct;
import com.AgustinMontoya.desafio.ddd.sell.values.ProductID;

public class CreateProductUseCase  extends UseCase<RequestCommand<AddProduct>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddProduct> addProductRequestCommand) {
        var command = addProductRequestCommand.getCommand();
        var product = Sell.from(command.getEntityId(),repository().getEventsBy(command.getEntityId().value()));
        product.createProduct(new ProductID(),command.getProductName(),command.getProductPrice());
        emit().onResponse(new ResponseEvents(product.getUncommittedChanges()));



    }}