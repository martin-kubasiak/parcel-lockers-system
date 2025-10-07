package com.app.userservice.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Location {

    @Getter
    private final double latitude;
    @Getter
    private final double longitude;
}
