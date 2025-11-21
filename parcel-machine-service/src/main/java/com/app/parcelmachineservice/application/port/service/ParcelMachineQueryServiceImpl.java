package com.app.parcelmachineservice.application.port.service;

import com.app.parcelmachineservice.application.port.input.dto.NearestParcelMachineDto;
import com.app.parcelmachineservice.application.port.output.ParcelMachineDataOutputPort;
import com.app.parcelmachineservice.application.port.output.dto.ParcelMachineResult;
import com.app.parcelmachineservice.domain.model.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParcelMachineQueryServiceImpl implements ParcelMachineQueryService {

    private final ParcelMachineDataOutputPort parcelMachineDataOutputPort;

    @Override
    public List<NearestParcelMachineDto> findNearestParcelMachines(Location location, double radiusKm) {
        return parcelMachineDataOutputPort
                .findNearest(location, radiusKm)
                .stream()
                .map(ParcelMachineResult::toNearestParcelMachineDto)
                .toList();
    }
}
