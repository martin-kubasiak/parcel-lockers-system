package com.app.userservice.infrastructure.output;

import com.app.userservice.application.port.output.ParcelMachineServiceOutputPort;
import com.app.userservice.domain.model.Location;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class ExternalParcelMachineRestAdapter implements ParcelMachineServiceOutputPort {

    private final RestClient restClient;

    public ExternalParcelMachineRestAdapter(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<String> findParcelMachinesWithinRadius(Location userLocation, double radiusKm) {
        return List.of();
    }
}
