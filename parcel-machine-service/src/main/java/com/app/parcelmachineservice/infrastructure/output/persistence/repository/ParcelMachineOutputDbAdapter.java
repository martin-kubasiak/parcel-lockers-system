package com.app.parcelmachineservice.infrastructure.output.persistence.repository;

import com.app.parcelmachineservice.application.port.output.ParcelMachinePersistencePort;
import com.app.parcelmachineservice.application.port.output.dto.ExternalParcelMachineData;
import com.app.parcelmachineservice.domain.model.Location;
import com.app.parcelmachineservice.domain.model.ParcelMachine;
import com.app.parcelmachineservice.infrastructure.output.persistence.entity.ParcelMachineEntity;
import com.app.parcelmachineservice.infrastructure.output.persistence.entity.PersistenceMapper;
import com.app.parcelmachineservice.infrastructure.output.persistence.entity.utils.GeometryUtils;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Transactional
    @Override
    public List<ParcelMachine> saveAll(List<ExternalParcelMachineData> externalData) {

        var osmIds = externalData
                .stream()
                .map(ExternalParcelMachineData::getOsmId)
                .toList();

        List<ParcelMachineEntity> existingEntities = repository.findAllByOsmIdIn(osmIds);

        Map<Long, ParcelMachineEntity> existingEntitiesWithOsmId = existingEntities
                .stream()
                .collect(Collectors.toMap(
                        ParcelMachineEntity::getOsmId,
                        entity -> entity)
                );

        var toSave = externalData
                .stream()
                .map(data -> {
                    Point dbPoint = GeometryUtils.createPoint(
                            data.getLocation().getLongitude(),
                            data.getLocation().getLatitude()
                    );
                    var entity = existingEntitiesWithOsmId.getOrDefault(
                            data.getOsmId(),
                            ParcelMachineEntity
                                    .builder()
                                    .osmId(data.getOsmId())
                                    .build()
                    );
                    persistenceMapper.updateEntityFromExternal(entity, data, dbPoint);
                    return entity;
                })
                .toList();

        var saved = repository.saveAll(toSave);
        return saved
                .stream()
                .map(persistenceMapper::toParcelMachine)
                .toList();
    }
}
