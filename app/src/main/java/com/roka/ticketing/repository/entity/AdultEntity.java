package com.roka.ticketing.repository.entity;

public class AdultEntity extends PassengerEntity {

    public static AdultEntity copyFrom(PassengerEntity entity){
        AdultEntity result = new AdultEntity();

        result.setNumOrder(entity.getNumOrder());
        result.setEmail(entity.getEmail());
        result.setFirstName(entity.getFirstName());
        result.setLastName(entity.getLastName());
        result.setIdentityNumber(entity.getIdentityNumber());
        result.setPhoneNumber(entity.getPhoneNumber());
        result.setSuffix(entity.getSuffix());
        result.setUid(entity.getUid());
        return result;
    }
}
