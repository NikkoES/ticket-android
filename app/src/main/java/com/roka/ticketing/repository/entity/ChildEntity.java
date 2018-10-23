package com.roka.ticketing.repository.entity;

public class ChildEntity extends PassengerEntity {
    public static ChildEntity copyFrom(PassengerEntity entity){
        ChildEntity result = new ChildEntity();

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
