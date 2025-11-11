package com.app.parcelmachineservice.application.port.output;

import com.app.parcelmachineservice.application.port.output.dto.ParcelMachineResult;
import com.app.parcelmachineservice.domain.model.Location;

import java.util.List;

public interface ParcelMachineDataOutputPort {
    List<ParcelMachineResult> findNearest(Location location, double radiusKm);
}
