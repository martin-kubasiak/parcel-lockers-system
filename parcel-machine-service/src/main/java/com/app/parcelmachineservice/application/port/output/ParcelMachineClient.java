package com.app.parcelmachineservice.application.port.output;

import com.app.parcelmachineservice.domain.model.Location;

import java.util.Optional;

public interface ParcelMachineClient {

    Optional<ParcelMachineResult> findNearest(Location location, double radiusKm);

}
