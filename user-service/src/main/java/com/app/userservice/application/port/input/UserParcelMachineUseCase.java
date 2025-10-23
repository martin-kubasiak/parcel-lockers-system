package com.app.userservice.application.port.input;

import com.app.userservice.domain.model.ParcelMachinePreference;
import com.app.userservice.domain.model.User;

public interface UserParcelMachineUseCase {
    ParcelMachinePreference suggestNearestParcelMachine(User user, String label, double radiusKm);
}
