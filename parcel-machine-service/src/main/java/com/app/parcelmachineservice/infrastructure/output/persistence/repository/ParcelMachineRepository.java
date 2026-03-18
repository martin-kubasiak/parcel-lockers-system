package com.app.parcelmachineservice.infrastructure.output.persistence.repository;

import com.app.parcelmachineservice.infrastructure.output.persistence.entity.ParcelMachineEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParcelMachineRepository extends ListCrudRepository<ParcelMachineEntity, UUID> {
    Optional<ParcelMachineEntity> findByOsmId(Long osmId);

    List<ParcelMachineEntity> findAllByOsmIdIn(List<Long> ids);

    @Query(value = """
            SELECT * FROM parcel_machines pm
            WHERE MBRContains(
                    ST_GeomFromText(
                        CONCAT('POLYGON((',
                            :minLat, ' ', :minLon, ', ',
                            :maxLat, ' ', :minLon, ', ',
                            :maxLat, ' ', :maxLon, ', ',
                            :minLat, ' ', :maxLon, ', ',
                            :minLat, ' ', :minLon,
                        '))'),
                        4326
                    ),
                    pm.location
            )
            AND ST_Distance_Sphere(
                        pm.location,
                        ST_GeomFromText(CONCAT('POINT(', :lat, ' ', :lon, ')'), 4326)
                ) <= :radius
            """, nativeQuery = true)
    List<ParcelMachineEntity> findNearest(
            @Param("minLat") double minLat,
            @Param("minLon") double minLon,
            @Param("maxLat") double maxLat,
            @Param("maxLon") double maxLon,
            @Param("lat") double lat,
            @Param("lon") double lon,
            @Param("radius") double radiusInMeters);

}
