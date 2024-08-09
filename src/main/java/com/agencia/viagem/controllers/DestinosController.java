package com.agencia.viagem.controllers;

import com.agencia.viagem.dtos.DestinosRecordDto;
import com.agencia.viagem.models.DestinosModel;
import com.agencia.viagem.repositories.DestinosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/destinos")
public class DestinosController {
    @Autowired
    DestinosRepository destinoRepository;

    @GetMapping
    public ResponseEntity<List<DestinosModel>> getAllDestinos(){
        return ResponseEntity.status(HttpStatus.OK).body(destinoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinosModel> getDestinoById(@PathVariable Long id) {
        Optional<DestinosModel> destinoOpt = destinoRepository.findById(id);
        if (destinoOpt.isPresent()) {
            return ResponseEntity.ok(destinoOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<DestinosModel> createDestino(@Validated @RequestBody DestinosRecordDto destinoDto) {
        DestinosModel destino = new DestinosModel();
        BeanUtils.copyProperties(destinoDto, destino);
        return ResponseEntity.status(HttpStatus.CREATED).body(destinoRepository.save(destino));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DestinosModel> updateDestino(@PathVariable Long id, @Validated @RequestBody DestinosRecordDto destinoDto) {
        Optional<DestinosModel> destinoOpt = destinoRepository.findById(id);
        if (destinoOpt.isPresent()) {
            DestinosModel destino = destinoOpt.get();
            BeanUtils.copyProperties(destinoDto, destino);
            return ResponseEntity.ok(destinoRepository.save(destino));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestino(@PathVariable Long id) {
        if (destinoRepository.existsById(id)) {
            destinoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
