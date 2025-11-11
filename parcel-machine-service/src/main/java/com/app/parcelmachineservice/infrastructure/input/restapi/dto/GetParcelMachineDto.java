package com.app.parcelmachineservice.infrastructure.input.restapi.dto;

import com.app.parcelmachineservice.domain.model.Location;

public record GetParcelMachineDto(
        String ref,
        String brand,
        String operator,
        double lat,
        double lon
) {
}
