package com.app.parcelmachineservice.infrastructure.input.restapi.dto;

public record ResponseResult<T>(T data, String error) {
    public ResponseResult(T data) {
        this(data, null);
    }
}
