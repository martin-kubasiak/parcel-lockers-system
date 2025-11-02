package com.app.userservice.infrastructure.input.restapi;

import com.app.userservice.application.port.input.FindNearestParcelMachinesUseCase;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParcelMachineRestAdapter {
    private final FindNearestParcelMachinesUseCase useCase;

    public ParcelMachineRestAdapter(FindNearestParcelMachinesUseCase useCase) {
        this.useCase = useCase;
    }
}
