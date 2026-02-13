package com.app.parcelmachineservice.application.port.output.dto;

import com.app.parcelmachineservice.application.port.input.dto.NearestParcelMachineDto;
import com.app.parcelmachineservice.domain.model.Location;
import com.app.parcelmachineservice.infrastructure.output.dto.GetOverpassElementsDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExternalParcelMachineData {
    private final Long osmId;
    private final String ref;
    private final String brand;
    private final String operator;
    private final String street;
    private final String city;
    private final Location location;

    public static ExternalParcelMachineData from(GetOverpassElementsDto.Element element) {
        var tags = element.tags();
        var brand = tags.getOrDefault("brand", "UNKNOWN");

        return new ExternalParcelMachineData(
                element.id(),
                tags.getOrDefault("ref", "NO_REF"),
                brand,
                tags.getOrDefault("operator", brand),
                tags.getOrDefault("addr:street", null),
                tags.getOrDefault("addr:city", null),
                new Location(element.lat(), element.lon()));
    }
}
