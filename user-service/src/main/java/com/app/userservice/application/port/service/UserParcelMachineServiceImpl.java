package com.app.userservice.application.port.service;

import com.app.userservice.application.port.output.ParcelMachineClient;
import com.app.userservice.domain.model.ParcelMachinePreference;
import com.app.userservice.domain.model.User;

import java.util.List;


public class UserParcelMachineServiceImpl implements  UserParcelMachineService{

    private final ParcelMachineClient parcelMachineClient;

    public UserParcelMachineServiceImpl(ParcelMachineClient parcelMachineClient) {
        this.parcelMachineClient = parcelMachineClient;
    }

    @Override
    public ParcelMachinePreference suggestNearestParcelMachine(User user, String label, double radiusKm) {
        return null;
    }
}
