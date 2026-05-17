package dev.java.management.mapper;

import dev.java.management.request.PositionRequest;
import dev.java.management.response.PositionResponse;
import dev.java.management.entity.Position;

import lombok.experimental.UtilityClass;

@UtilityClass

public class PositionMapper {

    public static Position toPosition(PositionRequest request){

        return Position.builder()
                .title(request.title())
                .description(request.description())
                .salary(request.salary())
                .seniority(request.seniority())
                .build();
    }

    public static PositionResponse toPositionResponse(Position position){

        return PositionResponse.builder()
                .id(position.getId())
                .title(position.getTitle())
                .description(position.getDescription())
                .salary(position.getSalary())
                .seniority(position.getSeniority())
                .build();
    }

    }

