package com.app.parcelmachineservice.application.port.output.dto;

import com.app.parcelmachineservice.application.port.input.dto.NearestParcelMachineDto;
import com.app.parcelmachineservice.domain.model.Location;
import com.app.parcelmachineservice.infrastructure.output.dto.GetOverpassParcelMachinesResponseDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ParcelMachineResult {
    private final String ref;
    private final String brand;
    private final String operator;
    private final Location location;

    public NearestParcelMachineDto toParcelMachineDto() {
        return new NearestParcelMachineDto(ref, brand, operator, location.getLatitude(), location.getLongitude());
    }

    public static ParcelMachineResult from(GetOverpassParcelMachinesResponseDto.Element element) {
        var tags = element.tags();
        return new ParcelMachineResult(tags.get("ref"),
                tags.getOrDefault("brand", "UNKNOWN"),
                tags.getOrDefault("operator", "UNKNOWN"),
                new Location(element.lat(), element.lon()));
    }
}
