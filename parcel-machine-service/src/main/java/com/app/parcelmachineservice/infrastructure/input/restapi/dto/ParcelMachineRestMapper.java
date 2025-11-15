package com.app.parcelmachineservice.infrastructure.input.restapi.dto;

import com.app.parcelmachineservice.application.port.input.dto.NearestParcelMachineDto;

public class ParcelMachineRestMapper {

    public static GetParcelMachineDto toGetParcelMachineDto(NearestParcelMachineDto sourceDto) {
        return new GetParcelMachineDto(sourceDto.ref(),
                sourceDto.brand(),
                sourceDto.operator(),
                sourceDto.lat(),
                sourceDto.lon()
        );
    }
}
