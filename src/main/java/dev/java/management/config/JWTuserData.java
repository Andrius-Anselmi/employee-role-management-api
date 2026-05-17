package dev.java.management.config;

import lombok.Builder;

@Builder
public record JWTuserData(Long id, String name, String email) {
}
