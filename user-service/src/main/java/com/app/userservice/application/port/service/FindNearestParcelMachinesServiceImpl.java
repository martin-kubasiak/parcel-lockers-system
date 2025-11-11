package com.app.userservice.application.port.service;

import com.app.userservice.application.port.output.ParcelMachineServiceOutputPort;
import com.app.userservice.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindNearestParcelMachinesServiceImpl implements FindNearestParcelMachinesService {

    private final ParcelMachineServiceOutputPort parcelMachineClient;

    public FindNearestParcelMachinesServiceImpl(ParcelMachineServiceOutputPort parcelMachineClient) {
        this.parcelMachineClient = parcelMachineClient;
    }

    @Override
    public List<String> findNearestParcelMachines(User user, double radiusKm) {
        var userLocation = user.getLocation();
        return parcelMachineClient.findNearestParcelMachines(userLocation, radiusKm);
    }
}
