package com.app.parcelmachineservice.domain.model;

import com.app.parcelmachineservice.infrastructure.input.restapi.dto.GetParcelMachineDto;

public class ParcelMachine {

    ParcelMachineId id;
    String brand;
    String operator;
    Location location;

    public GetParcelMachineDto toGetParcelMachineDto() {
        return new GetParcelMachineDto(
                id.id().toString(),
                brand,
                operator,
                location.getLatitude(),
                location.getLongitude());
    }
}
