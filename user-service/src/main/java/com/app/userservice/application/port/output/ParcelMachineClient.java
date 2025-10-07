package com.app.userservice.application.port.output;

import com.app.userservice.domain.model.Location;

import java.util.Optional;

public interface ParcelMachineClient {

    Optional<ParcelMachineResult> findNearest(Location userLocation, double radiusKm);

}
