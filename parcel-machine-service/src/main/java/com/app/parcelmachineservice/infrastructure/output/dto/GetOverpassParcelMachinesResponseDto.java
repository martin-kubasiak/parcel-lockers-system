package com.app.parcelmachineservice.infrastructure.output.dto;

import java.util.List;
import java.util.Map;

public record GetOverpassParcelMachinesResponseDto(
        List<Element> elements
) {
    public record Element(
            String type,
            long id,
            double lat,
            double lon,
            Map<String, String> tags
    ) {
    }
}
