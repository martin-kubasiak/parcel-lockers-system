package com.app.userservice.application.port.input;

import com.app.userservice.domain.model.User;

import java.util.List;

public interface UserParcelMachineUseCase {
    List<String> findTopNearestParcelMachines(User user, double radiusKm);
}
