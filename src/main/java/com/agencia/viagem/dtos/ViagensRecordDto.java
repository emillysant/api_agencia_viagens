package com.agencia.viagem.dtos;

import com.agencia.viagem.validators.ValidDateRange;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

// como garantir q a data de viagem de dataInicio seja antes da de fim?
@ValidDateRange
public record ViagensRecordDto(@NotBlank String name, @NotNull LocalDate dataInicio, @NotNull LocalDate dataFim,  @NotNull Long destinoId) {
}
