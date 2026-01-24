package com.app.parcelmachineservice.application.port.service;

import com.app.parcelmachineservice.application.port.input.dto.NearestParcelMachineDto;
import com.app.parcelmachineservice.application.port.input.dto.ParcelMachineMapper;
import com.app.parcelmachineservice.application.port.output.ParcelMachineExternalApiPort;
import com.app.parcelmachineservice.application.port.output.ParcelMachinePersistencePort;
import com.app.parcelmachineservice.application.port.output.dto.ExternalParcelMachineData;
import com.app.parcelmachineservice.domain.model.Location;
import com.app.parcelmachineservice.domain.model.ParcelMachine;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParcelMachineQueryServiceImpl implements ParcelMachineQueryService {

    private final ParcelMachineExternalApiPort externalApiPort;
    private final ParcelMachinePersistencePort persistencePort;
    @Value("${spring.application.db-record-freshness-threshold}")
    private Duration freshnessThreshold;

    @Override
    public List<NearestParcelMachineDto> findNearestParcelMachines(Location location, double radiusKm) {

        var localResults = persistencePort.findNearest(location, radiusKm);
        var areResultsFresh = localResults
                .stream()
                .allMatch(pm -> pm.isFresh(freshnessThreshold));

        if (localResults.isEmpty() || !areResultsFresh) {
            var externalData = externalApiPort.fetchNearest(location, radiusKm);
            localResults = persistencePort.saveAll(externalData);
        }

        return localResults.stream()
                .map(ParcelMachineMapper::toNearestParcelMachineDto)
                .toList();
    }
}
