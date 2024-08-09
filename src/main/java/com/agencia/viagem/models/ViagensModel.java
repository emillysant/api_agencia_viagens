package com.agencia.viagem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;
import java.time.LocalDate;


@Entity
@Table(name = "viagens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ViagensModel implements Serializable {
    private  static final long serialVersionUID =1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private DestinosModel destino;

}
