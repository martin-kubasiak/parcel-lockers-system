package com.app.parcelmachineservice.domain.service;

import com.app.parcelmachineservice.domain.model.Location;
import com.app.parcelmachineservice.domain.model.ParcelMachine;

import java.util.List;

public interface ParcelMachineFinder {
    List<ParcelMachine> findNearestParcelMachines(Location userLocation, List<ParcelMachine> machines, double radiusKm);
}
