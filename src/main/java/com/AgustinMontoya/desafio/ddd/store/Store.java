package com.AgustinMontoya.desafio.ddd.store;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.AgustinMontoya.desafio.ddd.store.events.*;
import com.AgustinMontoya.desafio.ddd.store.values.*;

import java.util.List;
import java.util.Objects;

public class Store extends AggregateEvent<StoreID> {
    protected StatusStore statusStore;
    protected  AddressStore addressStore;
    protected Owner owner;
    protected Deposit deposit;
    protected Manager manager;




    public Store(StoreID entityId, AddressStore addressStore, StatusStore statusStore) {
        super(entityId);
        appendChange(new StoreCreated(addressStore,statusStore)).apply();
    }
    private Store(StoreID entityId){
        super(entityId);
        subscribe(new StoreChange(this));
    }
    public static Store from(StoreID storeID, List<DomainEvent> events){
        var store = new Store(storeID);
        events.forEach(store::applyEvent);
        return store;


    }
    public void createOwner(OwnerID entityId, OwnerName ownerName, OwnerPhone ownerPhone){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(ownerName);
        Objects.requireNonNull(ownerPhone);
        appendChange(new OwnerCreated(entityId, ownerName, ownerPhone)).apply();
    }
    public void createDeposit(DepositID entityId, DepositCapacity depositCapacity ){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(depositCapacity) ;

        appendChange(new DepositCreated(entityId,depositCapacity )).apply();
    }
    public void createManager(ManagerID entityId, ManagerName managerName , ManagerMail managerMail){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(managerName) ;
        Objects.requireNonNull(managerMail) ;

        appendChange(new ManagerCreated(entityId,managerName ,managerMail )).apply();
    }
    public void updateAddres(AddressStore addressStore){
        Objects.requireNonNull(addressStore) ;
        appendChange(new AddresUpdated(addressStore)).apply();

    }
    public void updateStatus(StatusStore statusStore){
        Objects.requireNonNull(statusStore) ;
        appendChange(new StatusUpdated(statusStore)).apply();

    }
    public void updatePhoneOwner(OwnerPhone ownerPhone){
        Objects.requireNonNull(ownerPhone) ;
        appendChange(new UpdatedPhoneOwner(ownerPhone)).apply();

    }
    public void updateMailManager(ManagerMail managerMail){
        Objects.requireNonNull(managerMail) ;
        appendChange(new ManagerMailUpdated(managerMail)).apply();

    }
    public void contactManager(ManagerMail managerMail){
        Objects.requireNonNull(managerMail) ;
        appendChange(new OwnerContacted_Manager(managerMail)).apply();

    }
    public void updateCapacity(DepositCapacity depositCapacity){
        Objects.requireNonNull(depositCapacity) ;
        appendChange(new CapacityUpdated(depositCapacity)).apply();
    }
    public void paySallariesOwner(OwnerPhone ownerPhone){
        Objects.requireNonNull(ownerPhone) ;
        appendChange(new SallariedPayed(ownerPhone)).apply();

    }
    public void contactProvider(DepositCapacity depositCapacity){
        Objects.requireNonNull(depositCapacity) ;
        appendChange(new ProviderContacted(depositCapacity)).apply();
    }




    public StatusStore getStatusStore() {        return statusStore;
    }

    public void setStatusStore(StatusStore statusStore) {        this.statusStore = statusStore;
    }

    public AddressStore getAddressStore() {        return addressStore;
    }

    public void setAddressStore(AddressStore addressStore) {        this.addressStore = addressStore;
    }

    public Owner getOwner() {        return owner;
    }

    public void setOwner(Owner owner) {        this.owner = owner;
    }

    public Deposit getDeposit() {        return deposit;
    }

    public void setDeposit(Deposit deposit) {        this.deposit = deposit;
    }

    public Manager getManager() {        return manager;
    }

    public void setManager(Manager manager) {        this.manager = manager;
    }
}
