package com.app.userservice.application.port.output;

import com.app.userservice.domain.model.Location;

public record ParcelMachineResult(String machineId, String labal, Location location) {
}
