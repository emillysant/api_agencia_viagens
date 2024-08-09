package com.agencia.viagem.repositories;

import com.agencia.viagem.models.ViagensModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ViagensRepository extends JpaRepository<ViagensModel, Long> {
    List<ViagensModel> findByDestinoId(Long destinoId);
}
