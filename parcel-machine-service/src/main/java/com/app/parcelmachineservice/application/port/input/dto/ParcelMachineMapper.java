package com.app.parcelmachineservice.application.port.input.dto;

import com.app.parcelmachineservice.domain.model.ParcelMachine;

public class ParcelMachineMapper {
    public static NearestParcelMachineDto toNearestParcelMachineDto(ParcelMachine domain) {
        return new NearestParcelMachineDto(domain.getRef(),
                domain.getBrand(),
                domain.getOperator(),
                domain.getLocation().getLatitude(),
                domain.getLocation().getLongitude()
        );
    }
}
