package com.roka.ticketing.repository.entity;

public class InfantEntity extends PassengerEntity {

    public static InfantEntity copyFrom(PassengerEntity entity){
        InfantEntity result = new InfantEntity();

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
