package com.app.userservice.infrastructure.output;

import com.app.userservice.application.port.output.ParcelMachineClient;
import com.app.userservice.application.port.output.ParcelMachineResult;
import com.app.userservice.domain.model.Location;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Component
public class OverpassParcelMachineClient implements ParcelMachineClient {

    private final String baseUrl;
    private final RestClient restClient;

    public OverpassParcelMachineClient(
            @Value("${overpass.base-url}")
            String baseUrl,
            RestClient restClient) {
        this.baseUrl = baseUrl;
        this.restClient = restClient;
    }

    @Override
    public Optional<ParcelMachineResult> findNearest(Location userLocation, double radiusKm) {
        return Optional.empty();
    }
}
