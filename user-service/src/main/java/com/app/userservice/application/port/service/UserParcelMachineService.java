package com.app.userservice.application.port.service;

import com.app.userservice.application.port.input.UserParcelMachineUseCase;
import com.app.userservice.application.port.output.ParcelMachineClient;
import com.app.userservice.domain.model.ParcelMachinePreference;
import com.app.userservice.domain.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserParcelMachineService implements UserParcelMachineUseCase {

    private final UserRepository userRepository;
    private final ParcelMachineClient parcelMachineClient;

    @Override
    public ParcelMachinePreference suggestAndSaveNearestParcelMachine(Long userId, String label) {
        return null;
    }
}
