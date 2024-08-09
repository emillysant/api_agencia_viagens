package com.agencia.viagem.dtos;

import jakarta.validation.constraints.NotBlank;

public record DestinosRecordDto(@NotBlank String nome, @NotBlank String pais) {
}
