package com.app.parcelmachineservice.application.port.output;

import com.app.parcelmachineservice.application.port.output.dto.ExternalParcelMachineData;
import com.app.parcelmachineservice.domain.model.Location;

import java.util.List;

public interface ParcelMachineExternalApiPort {
    List<ExternalParcelMachineData> fetchNearest(Location location, double radiusKm);
}
