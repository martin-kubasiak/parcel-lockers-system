package com.app.userservice.infrastructure.input.restapi;

import com.app.userservice.application.port.input.UserParcelMachineUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserParcelMachineRestController {
    private final UserParcelMachineUseCase useCase;

    public UserParcelMachineRestController(UserParcelMachineUseCase useCase) {
        this.useCase = useCase;
    }
}
