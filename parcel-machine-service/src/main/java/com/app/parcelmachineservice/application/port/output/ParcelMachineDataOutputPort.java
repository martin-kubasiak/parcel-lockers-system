package com.app.parcelmachineservice.application.port.output;

import com.app.parcelmachineservice.domain.model.Location;

import java.util.List;
import java.util.Optional;

public interface ParcelMachineDataOutputPort {
    List<ParcelMachineResult> findNearest(Location location, double radiusKm);
}
