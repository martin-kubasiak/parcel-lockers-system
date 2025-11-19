package com.app.parcelmachineservice.infrastructure.input.restapi.dto;

public record GetParcelMachineDto(
        String ref,
        String brand,
        String operator,
        double lat,
        double lon
) {
}
