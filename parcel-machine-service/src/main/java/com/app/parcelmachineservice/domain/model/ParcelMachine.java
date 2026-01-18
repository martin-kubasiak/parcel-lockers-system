package com.app.parcelmachineservice.domain.model;

import java.time.LocalDateTime;

public class ParcelMachine {
    String id;
    Long osmId;
    String ref;
    String brand;
    String operator;
    Location location;
    LocalDateTime lastUpdated;
}
