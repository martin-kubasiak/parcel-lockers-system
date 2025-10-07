package com.app.userservice.infrastructure.output;

import com.app.userservice.application.port.output.ParcelMachineClient;
import com.app.userservice.application.port.output.ParcelMachineResult;
import com.app.userservice.domain.model.Location;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;

public class OverpassParcelMachineClient implements ParcelMachineClient {

    private final String baseUrl;

    public OverpassParcelMachineClient(@Value("${overpass.base-url}") String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public Optional<ParcelMachineResult> findNearest(Location userLocation, double radiusKm) {
        return Optional.empty();
    }
}
