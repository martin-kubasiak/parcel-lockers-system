package com.app.userservice.infrastructure.input.restapi;

import com.app.userservice.application.port.input.UserParcelMachineUseCase;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserParcelMachineUseCase useCase;

    public UserController(UserParcelMachineUseCase useCase) {
        this.useCase = useCase;
    }
}
