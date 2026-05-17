package dev.java.management.response;

import lombok.Builder;
@Builder
public record EmployeeResponse(Long id, String name, int age, String state, String city, PositionResponse position) {

}

