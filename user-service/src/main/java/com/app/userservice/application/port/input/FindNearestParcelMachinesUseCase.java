package com.app.userservice.application.port.input;

import com.app.userservice.domain.model.User;

import java.util.List;

public interface FindNearestParcelMachinesUseCase {
    List<String> findNearestParcelMachines(User user, double radiusKm);
}
