package com.app.userservice.domain.model;

import lombok.Getter;

public class User {

    UserId id;
    String firstName;
    String lastName;
    String email;
    String password;
    @Getter
    Location location;
    ParcelMachinePreference parcelMachinePreference;

}
