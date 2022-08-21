package com.AgustinMontoya.desafio.ddd.store;

import co.com.sofka.domain.generic.EventChange;
import com.AgustinMontoya.desafio.ddd.store.events.*;
import com.AgustinMontoya.desafio.ddd.store.values.AddressStore;
import com.AgustinMontoya.desafio.ddd.store.values.DepositID;
import com.AgustinMontoya.desafio.ddd.store.values.StatusStore;

public class StoreChange extends EventChange {
    public StoreChange(Store store){
        apply((StoreCreated event) ->{
            store.addressStore = event.getAddressStore();
            store.statusStore = event.getStatusStore();

        });
        apply((DepositCreated event) ->{

            store.deposit = new Deposit(event.EntityId(), event.getDepositCapacity());

        });
        apply((ManagerCreated event) ->{
            store.manager = new Manager(event.getEntityId(),event.getManagerName(),event.getManagerMail());


        });

        apply((OwnerCreated event) ->{
            store.owner = new Owner(event.getEntityId(),event.getOwnerName(), event.getOwnerPhone());

        });
        apply((UpdatedPhoneOwner event) ->{

            store.owner.updatePhoneOwner(event.getOwnerPhone());

        });
        apply((ManagerMailUpdated event) ->{
            store.manager.updateMailManager(event.getManagerMail());

        });
        apply((AddresUpdated event) ->{
            store.updateAddres(event.getAddressStore());


        });
        apply((CapacityUpdated event) ->{
            store.deposit.updateCapacity(event.getDepositCapacity());

        });
        apply((StatusUpdated event) ->{
            store.updateStatus(event.getStatusStore());

        });
        apply((SallariedPayed event) ->{
            store.owner.updatePhoneOwner(event.getOwnerPhone());

        });
        apply((OwnerContacted_Manager event) ->{
            store.manager.contactManager(event.getManagerMail());

        });
        apply((ProviderContacted event) ->{
            store.deposit.contactProvider(event.getDepositCapacity());

        });








    }
}
