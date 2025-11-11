package com.app.parcelmachineservice.application.port.input.dto;

import com.app.parcelmachineservice.application.port.output.dto.ParcelMachineResult;
import com.app.parcelmachineservice.domain.model.Location;
import com.app.parcelmachineservice.infrastructure.output.dto.GetOverpassParcelMachinesResponseDto;

public record ParcelMachineDto(
        String ref,
        String brand,
        String operator,
        double lat,
        double lon
) {}
