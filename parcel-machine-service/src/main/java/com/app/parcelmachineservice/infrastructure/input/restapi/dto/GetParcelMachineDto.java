package com.app.parcelmachineservice.infrastructure.input.restapi.dto;

public record GetParcelMachineDto(
        String id,
        double latitude,
        double longitude
) {
}
