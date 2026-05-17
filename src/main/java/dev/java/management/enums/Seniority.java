package dev.java.management.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Seniority {
    JUNIOR, MID_LEVEL, SENIOR,TECH_LEAD;

    @JsonCreator
    public static Seniority fromString(String valor){
        return Seniority.valueOf(valor.toUpperCase());
    }
}
