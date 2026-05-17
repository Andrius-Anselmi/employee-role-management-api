package dev.java.management.request;

import dev.java.management.enums.Seniority;

import java.math.BigDecimal;

public record PositionRequest(String title, String description, BigDecimal salary, Seniority seniority){
}




