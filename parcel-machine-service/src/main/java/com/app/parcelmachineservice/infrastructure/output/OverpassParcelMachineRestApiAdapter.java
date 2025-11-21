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
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class OverpassParcelMachineRestApiAdapter implements ParcelMachineDataOutputPort {

    private final RestClient restClient;

    @Override
    public List<ParcelMachineResult> findNearest(Location location, double radiusKm) {

        String query = String.format(Locale.ROOT,
                "[out:json];node[\"amenity\"=\"parcel_locker\"](around:%f,%f,%f);out body;",
                radiusKm * 1000,
                location.getLatitude(),
                location.getLongitude()
        );
        String url = "/interpreter?data=" + query;

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
