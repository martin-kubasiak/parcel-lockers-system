package com.app.parcelmachineservice.infrastructure.output.persistence.entity;

import com.app.parcelmachineservice.domain.model.Location;
import com.app.parcelmachineservice.domain.model.ParcelMachine;
import com.app.parcelmachineservice.domain.model.ParcelMachineId;
import org.springframework.stereotype.Component;

@Component
public class PersistenceMapper {

    public ParcelMachine toParcelMachine(ParcelMachineEntity entity) {
        return ParcelMachine.builder()
                .id(new ParcelMachineId(entity.getId()))
                .osmId(entity.getOsmId())
                .ref(entity.getOverpassRef())
                .brand(entity.getName())
                .operator(entity.getOperator())
                .location(new Location(
                        entity.getLocation().getY(),
                        entity.getLocation().getX())
                )
                .lastUpdated(entity.getLastUpdated())
                .build();
    }
}
