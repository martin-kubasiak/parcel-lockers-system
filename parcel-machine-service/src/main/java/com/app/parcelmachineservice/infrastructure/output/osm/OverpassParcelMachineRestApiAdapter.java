package com.app.parcelmachineservice.infrastructure.output.osm;

import com.app.parcelmachineservice.application.port.output.ParcelMachineExternalApiPort;
import com.app.parcelmachineservice.application.port.output.dto.ExternalParcelMachineData;
import com.app.parcelmachineservice.domain.model.Location;
import com.app.parcelmachineservice.infrastructure.output.dto.GetOverpassElementsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class OverpassParcelMachineRestApiAdapter implements ParcelMachineExternalApiPort {

    private final RestClient restClient;

    @Override
    public List<ExternalParcelMachineData> fetchNearest(Location location, double radiusKm) {

        String query = String.format(Locale.ROOT,
                "[out:json][timeout:30];node[\"amenity\"=\"parcel_locker\"](around:%f,%f,%f);out body;",
                radiusKm * 1000,
                location.getLatitude(),
                location.getLongitude()
        );
        String url = "/interpreter?data=" + query;

        var response = restClient
                .get()
                .uri(url)
                .retrieve()
                .body(GetOverpassElementsDto.class);

        return response != null && response.elements() != null ?
                response
                        .elements()
                        .stream()
                        .map(ExternalParcelMachineData::from)
                        .toList() :
                List.of();

    }
}
