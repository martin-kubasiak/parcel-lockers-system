package com.app.parcelmachineservice.domain.model;

import com.app.parcelmachineservice.application.port.input.dto.NearestParcelMachineDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Builder
@Getter
public class ParcelMachine {
    private final ParcelMachineId id;
    private final Long osmId;
    private final String ref;
    private final String brand;
    private final String operator;
    private final Location location;
    private final LocalDateTime lastUpdated;

    public boolean isFresh(Duration threshold) {
        return lastUpdated.isAfter(
                LocalDateTime.now().minus(threshold)
        );
    }

    public NearestParcelMachineDto toNearestParcelMachineDto() {
        return new NearestParcelMachineDto(
                ref,
                brand,
                operator,
                location.getLatitude(),
                location.getLongitude()
        );
    }
}
