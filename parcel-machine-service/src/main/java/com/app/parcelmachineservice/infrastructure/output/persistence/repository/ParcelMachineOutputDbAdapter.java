package com.app.parcelmachineservice.infrastructure.output.persistence.repository;

import com.app.parcelmachineservice.application.port.output.ParcelMachinePersistencePort;
import com.app.parcelmachineservice.application.port.output.dto.ExternalParcelMachineData;
import com.app.parcelmachineservice.domain.model.Location;
import com.app.parcelmachineservice.domain.model.ParcelMachine;
import com.app.parcelmachineservice.infrastructure.output.persistence.entity.ParcelMachineEntity;
import com.app.parcelmachineservice.infrastructure.output.persistence.entity.PersistenceMapper;
import com.app.parcelmachineservice.infrastructure.output.persistence.entity.utils.GeometryUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ParcelMachineOutputDbAdapter implements ParcelMachinePersistencePort {
    private final ParcelMachineRepository repository;
    private final PersistenceMapper persistenceMapper;

    @Override
    public List<ParcelMachine> findNearest(Location location, double radiusKm) {
        var bbox = GeometryUtils.calculateBoundingBox(
                location.getLatitude(),
                location.getLongitude(),
                radiusKm
        );

        var pointWkt = "POINT(%f %f)".formatted(location.getLatitude(), location.getLongitude());

        List<ParcelMachineEntity> entities = repository.findNearest(
                bbox.minLon(), bbox.minLat(),
                bbox.maxLon(), bbox.maxLat(),
                pointWkt,
                radiusKm * 1000
        );
        return entities
                .stream()
                .map(persistenceMapper::toParcelMachine)
                .toList();
    }

    @Override
    public List<ParcelMachine> saveAll(List<ExternalParcelMachineData> externalData) {
        return List.of();
    }
}
