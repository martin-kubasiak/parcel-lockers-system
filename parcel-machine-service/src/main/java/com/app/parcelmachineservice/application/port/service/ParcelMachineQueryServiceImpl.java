package com.app.parcelmachineservice.application.port.service;

import com.app.parcelmachineservice.application.port.input.dto.NearestParcelMachineDto;
import com.app.parcelmachineservice.application.port.output.ParcelMachineExternalApiPort;
import com.app.parcelmachineservice.application.port.output.dto.ExternalParcelMachineData;
import com.app.parcelmachineservice.domain.model.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParcelMachineQueryServiceImpl implements ParcelMachineQueryService {

    private final ParcelMachineExternalApiPort parcelMachineDataOutputPort;

    @Override
    public List<NearestParcelMachineDto> findNearestParcelMachines(Location location, double radiusKm) {
        return parcelMachineDataOutputPort
                .fetchNearest(location, radiusKm)
                .stream()
                .map(ExternalParcelMachineData::toNearestParcelMachineDto)
                .toList();
    }
}
