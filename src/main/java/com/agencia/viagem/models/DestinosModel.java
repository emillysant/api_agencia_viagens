package com.agencia.viagem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "destinos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DestinosModel implements Serializable {
    private  static final long serialVersionUID =1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String pais;

    @OneToMany(mappedBy = "destino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ViagensModel> viagens;
}
