package com.app.parcelmachineservice.infrastructure.output.persistence.repository;

import com.app.parcelmachineservice.infrastructure.output.persistence.entity.ParcelMachineEntity;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParcelMachineRepository extends ListCrudRepository<ParcelMachineEntity, UUID> {
    Optional<ParcelMachineEntity> findByOsmId(Long osmId);

    @Query(value = """
            SELECT * FROM parcel_machines pm
            WHERE MBRContains(
                    ST_MakeEnvelope(
                        POINT(:minLon, :minLat),
                        POINT(:maxLon, :maxLat)
                    ),
                    pm.location
            )
            AND ST_Distance_Sphere(pm.location, ST_GeomFromText(:pointWkt, 4326)) <= :radius
            """, nativeQuery = true)
    List<ParcelMachineEntity> findNearest(
            @Param("minLon") double minLon,
            @Param("minLat") double minLat,
            @Param("maxLon") double maxLon,
            @Param("maxLat") double maxLat,
            @Param("pointWkt") String pointWkt,
            @Param("radius") double radiusInMeters);
}
