package com.app.parcelmachineservice.application.port.input;

import com.app.parcelmachineservice.application.port.input.dto.NearestParcelMachineDto;
import com.app.parcelmachineservice.domain.model.Location;

import java.util.List;

public interface QueryParcelMachinesUseCase {
    List<NearestParcelMachineDto> findNearestParcelMachines(Location location , double radiusKm);
}
