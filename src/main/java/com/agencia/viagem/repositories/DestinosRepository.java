package com.agencia.viagem.repositories;

import com.agencia.viagem.models.DestinosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DestinosRepository extends JpaRepository<DestinosModel, Long> {
}
