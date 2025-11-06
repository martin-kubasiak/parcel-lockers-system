package com.app.userservice.infrastructure.input.restapi;

import com.app.userservice.application.port.input.FindNearestParcelMachinesUseCase;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParcelMachineRestApiAdapter {
    private final FindNearestParcelMachinesUseCase useCase;

    public ParcelMachineRestApiAdapter(FindNearestParcelMachinesUseCase useCase) {
        this.useCase = useCase;
    }
}
