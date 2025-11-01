package com.app.userservice.infrastructure.input.restapi;

import com.app.userservice.application.port.input.FindNearestParcelMachinesUseCase;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestApiAdapter {
    private final FindNearestParcelMachinesUseCase useCase;

    public UserRestApiAdapter(FindNearestParcelMachinesUseCase useCase) {
        this.useCase = useCase;
    }
}
