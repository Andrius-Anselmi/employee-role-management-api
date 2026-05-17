package dev.java.management.mapper;


import dev.java.management.request.EmployeeRequest;
import dev.java.management.response.EmployeeResponse;
import dev.java.management.entity.Position;
import dev.java.management.entity.Employee;

import lombok.experimental.UtilityClass;


@UtilityClass
public class EmployeeMapper {

    public static Employee toEmployee(EmployeeRequest request){

        Position position = Position.builder().id(request.position_id()).build();

        return Employee.builder()
                .name(request.name())
                .age(request.age())
                .state(request.state())
                .city(request.city())
                .position(position)
                .build();
    }

    public static EmployeeResponse toEmployeeResponse(Employee employee){

        return EmployeeResponse.builder()
                .name(employee.getName())
                .id(employee.getId())
                .age(employee.getAge())
                .city(employee.getCity())
                .state(employee.getState())
                .position(PositionMapper.toPositionResponse(employee.getPosition()))
                .build();
    }
}
