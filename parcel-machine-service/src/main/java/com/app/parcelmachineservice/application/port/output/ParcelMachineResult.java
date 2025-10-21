package com.app.parcelmachineservice.application.port.output;

import com.app.parcelmachineservice.domain.model.Location;

public record ParcelMachineResult(String machineId, String labal, Location location) {
}
