package dev.java.Gerenciamento.DTO.Response;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String email) {
}
