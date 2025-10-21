package com.app.parcelmachineservice.infrastructure.output;

import com.app.parcelmachineservice.application.port.output.ParcelMachineClient;
import com.app.parcelmachineservice.application.port.output.ParcelMachineResult;
import com.app.parcelmachineservice.domain.model.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OverpassParcelMachineClient implements ParcelMachineClient {

    private final RestClient restClient;

    @Override
    public Optional<ParcelMachineResult> findNearest(Location location, double radiusKm) {
        return Optional.empty();
    }
}
