package com.app.parcelmachineservice.infrastructure.output;

import com.app.parcelmachineservice.application.port.output.ParcelMachineDataOutputPort;
import com.app.parcelmachineservice.application.port.output.ParcelMachineResult;
import com.app.parcelmachineservice.domain.model.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OverpassParcelMachineRestApiAdapter implements ParcelMachineDataOutputPort {

    private final RestClient restClient;

    @Override
    public Optional<ParcelMachineResult> findNearest(Location location, double radiusKm) {
        return Optional.empty();
    }
}
