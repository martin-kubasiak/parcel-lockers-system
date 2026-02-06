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

    @Query(value = "SELECT * FROM parel_machines pm WHERE ST_Distance_Sphere(pm.location,:point) <=:radius", nativeQuery = true)
    List<ParcelMachineEntity> findNearest(@Param("point") Point point, @Param("radius") double radiusInMeters);
}
