package com.app.userservice.application.port.service;

import com.app.userservice.application.port.output.ParcelMachineServiceOutputPort;
import com.app.userservice.domain.model.User;

import java.util.List;


public class UserParcelMachineServiceImpl implements UserParcelMachineService {

    private final ParcelMachineServiceOutputPort parcelMachineClient;

    public UserParcelMachineServiceImpl(ParcelMachineServiceOutputPort parcelMachineClient) {
        this.parcelMachineClient = parcelMachineClient;
    }

    @Override
    public List<String> findNearestParcelMachines(User user, double radiusKm) {
        var userLocation = user.getLocation();
        return parcelMachineClient.findParcelMachinesWithinRadius(userLocation, radiusKm);
    }
}
