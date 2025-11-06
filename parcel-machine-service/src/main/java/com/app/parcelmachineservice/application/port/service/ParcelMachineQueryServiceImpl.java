package com.app.parcelmachineservice.application.port.service;

import com.app.parcelmachineservice.application.port.output.ParcelMachineDataOutputPort;
import com.app.parcelmachineservice.domain.model.Location;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ParcelMachineQueryServiceImpl implements ParcelMachineQueryService{

    private final ParcelMachineDataOutputPort parcelMachineDataOutputPort;

    @Override
    public List<String> findNearestParcelMachines(Location location, double radiusKm) {

        var res = parcelMachineDataOutputPort.findNearest(location, radiusKm);

        return List.of();
    }
}
