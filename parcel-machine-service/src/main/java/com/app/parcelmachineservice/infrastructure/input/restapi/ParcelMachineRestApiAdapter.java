package com.app.parcelmachineservice.infrastructure.input.restapi;

import com.app.parcelmachineservice.application.port.input.QueryParcelMachinesUseCase;
import com.app.parcelmachineservice.domain.model.Location;
import com.app.parcelmachineservice.infrastructure.input.restapi.dto.GetParcelMachineDto;
import com.app.parcelmachineservice.infrastructure.input.restapi.dto.ParcelMachineRestMapper;
import com.app.parcelmachineservice.infrastructure.input.restapi.dto.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/parcel-machines")
@RequiredArgsConstructor
public class ParcelMachineRestApiAdapter {
    private final QueryParcelMachinesUseCase queryParcelMachinesUseCase;

    @GetMapping("/nearest")
    public ResponseResult<List<GetParcelMachineDto>> findNearestParcelMachines(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam double radius
    ) {
        var location = new Location(lat, lon);
        return new ResponseResult<>(queryParcelMachinesUseCase
                .findNearestParcelMachines(location, radius)
                .stream()
                .map(ParcelMachineRestMapper::toGetParcelMachineDto)
                .toList()
        );
    }
}
