package com.app.userservice.infrastructure.output;

import com.app.userservice.application.port.output.ParcelMachineClient;
import com.app.userservice.domain.model.Location;

import java.util.List;

public class HttpParcelMachineClient implements ParcelMachineClient {
    @Override
    public List<String> findParcelMachinesWithinRadius(Location location, double radiusKm) {
        return List.of();
    }
}
