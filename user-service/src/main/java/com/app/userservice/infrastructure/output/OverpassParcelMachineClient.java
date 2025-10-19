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
@RequiredArgsConstructor
public class OverpassParcelMachineClient implements ParcelMachineClient {

    private final RestClient restClient;

    @Override
    public Optional<ParcelMachineResult> findNearest(Location userLocation, double radiusKm) {
        return Optional.empty();
    }
}
