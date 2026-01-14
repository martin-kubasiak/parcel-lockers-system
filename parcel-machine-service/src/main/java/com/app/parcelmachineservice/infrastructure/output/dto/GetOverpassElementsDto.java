package com.app.parcelmachineservice.infrastructure.output.dto;

import java.util.List;
import java.util.Map;

public record GetOverpassElementsDto(
        List<Element> elements
) {
    public record Element(
            String type,
            Long id,
            double lat,
            double lon,
            Map<String, String> tags
    ) {
    }
}
