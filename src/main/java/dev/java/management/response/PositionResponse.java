package dev.java.management.response;


import dev.java.management.enums.Seniority;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record PositionResponse(Long id, String title, String description, BigDecimal salary, Seniority seniority){
}
