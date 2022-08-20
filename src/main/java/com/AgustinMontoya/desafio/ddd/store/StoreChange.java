package com.AgustinMontoya.desafio.ddd.store;

import co.com.sofka.domain.generic.EventChange;
import com.AgustinMontoya.desafio.ddd.store.events.*;
import com.AgustinMontoya.desafio.ddd.store.values.AddressStore;
import com.AgustinMontoya.desafio.ddd.store.values.StatusStore;

public class StoreChange extends EventChange {
    public StoreChange(Store store){
        apply((StoreCreated event) ->{
            store.addressStore = event.getAddressStore();
            store.statusStore = event.getStatusStore();

        });
        apply((DepositCreated event) ->{

            store.deposit.depositCapacity = event.getDepositCapacity();

        });
        apply((ManagerCreated event) ->{
            store.manager.managerMail = event.getManagerMail();
            store.manager.managerName = event.getManagerName();

        });
        apply((ManagerCreated event) ->{
            store.manager.managerMail = event.getManagerMail();
            store.manager.managerName = event.getManagerName();

        });
        apply((OwnerCreated event) ->{
            store.owner.ownerName = event.getOwnerName();
            store.owner.ownerPhone = event.getOwnerPhone();

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

//        ownerContacted_manager
//        providercontacted
//        salarrypayed




    }
}
