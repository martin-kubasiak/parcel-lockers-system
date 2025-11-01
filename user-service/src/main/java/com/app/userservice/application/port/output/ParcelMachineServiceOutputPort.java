package com.app.userservice.application.port.output;

import com.app.userservice.domain.model.Location;

import java.util.List;

public interface ParcelMachineServiceOutputPort {
    List<String> findParcelMachinesWithinRadius(Location location, double radiusKm);
}
