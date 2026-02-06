package com.app.parcelmachineservice.infrastructure.output.persistence.repository;

import com.app.parcelmachineservice.application.port.output.ParcelMachinePersistencePort;
import com.app.parcelmachineservice.application.port.output.dto.ExternalParcelMachineData;
import com.app.parcelmachineservice.domain.model.Location;
import com.app.parcelmachineservice.domain.model.ParcelMachine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ParcelMachineOutputDbAdapter implements ParcelMachinePersistencePort {
    private final ParcelMachineRepository parcelMachineRepository;

    @Override
    public List<ParcelMachine> findNearest(Location location, double radiusKm) {
        return List.of();
    }

    @Override
    public List<ParcelMachine> saveAll(List<ExternalParcelMachineData> externalData) {
        return List.of();
    }
}
