package com.app.userservice.application.port.input;

import com.app.userservice.domain.model.ParcelMachinePreference;

public interface UserParcelMachineUseCase {
    ParcelMachinePreference suggestAndSaveNearestParcelMachine(String userId);
}
