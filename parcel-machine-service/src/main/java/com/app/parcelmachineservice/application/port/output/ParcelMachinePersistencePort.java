package com.app.parcelmachineservice.application.port.output;

import com.app.parcelmachineservice.application.port.output.dto.ExternalParcelMachineData;
import com.app.parcelmachineservice.domain.model.Location;
import com.app.parcelmachineservice.domain.model.ParcelMachine;

import java.util.List;

public interface ParcelMachinePersistencePort {
    List<ParcelMachine> findNearest(Location location, double radiusKm);

    List<ParcelMachine> saveAll(List<ExternalParcelMachineData> externalData);
}
