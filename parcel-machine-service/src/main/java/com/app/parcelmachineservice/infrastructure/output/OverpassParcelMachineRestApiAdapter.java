package com.app.parcelmachineservice.infrastructure.output;

import com.app.parcelmachineservice.application.port.output.ParcelMachineDataOutputPort;
import com.app.parcelmachineservice.application.port.output.dto.ParcelMachineResult;
import com.app.parcelmachineservice.domain.model.Location;
import com.app.parcelmachineservice.infrastructure.output.dto.GetOverpassParcelMachinesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OverpassParcelMachineRestApiAdapter implements ParcelMachineDataOutputPort {

    private final RestClient restClient;

    @Override
    public List<ParcelMachineResult> findNearest(Location location, double radiusKm) {
        String query = """
                [out:json];
                node
                  ["amenity"="parcel_locker"]
                  (around:%f,%f,%f);
                out body;
                """.formatted(
                radiusKm * 1000,
                location.getLatitude(),
                location.getLongitude()
        );
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        String url = "/interpreter?data=" + encodedQuery;

        var response = restClient
                .get()
                .uri(url)
                .retrieve()
                .body(GetOverpassParcelMachinesResponseDto.class);

        return response != null && response.elements() != null ?
                response
                        .elements()
                        .stream()
                        .map(ParcelMachineResult::from)
                        .toList() :
                List.of();

    }
}
