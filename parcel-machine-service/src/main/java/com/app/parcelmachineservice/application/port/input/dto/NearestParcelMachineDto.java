package com.app.parcelmachineservice.application.port.input.dto;

public record NearestParcelMachineDto(
        String ref,
        String brand,
        String operator,
        double lat,
        double lon
) {}
