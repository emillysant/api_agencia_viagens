package com.agencia.viagem.controllers;

import com.agencia.viagem.dtos.ViagensRecordDto;
import com.agencia.viagem.models.ViagensModel;
import com.agencia.viagem.repositories.DestinosRepository;
import com.agencia.viagem.repositories.ViagensRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/viagens")
public class ViagensController {
    @Autowired
    ViagensRepository viagemRepository;

    @Autowired
    private DestinosRepository destinoRepository;

    @GetMapping
    public ResponseEntity<List<ViagensModel>> getAllViagens(){
        return ResponseEntity.status(HttpStatus.OK).body(viagemRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getViagemById(@PathVariable(value="id") Long id) {
        Optional<ViagensModel> viagem0 = viagemRepository.findById(id);
        if(viagem0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Viagem nao encontrada");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(viagem0.get());
        }
    }

    @PostMapping
    public ResponseEntity<ViagensModel> createViagem(@Validated @RequestBody ViagensRecordDto viagemDto) {
        ViagensModel viagem = new ViagensModel();
        var destinoOpt = destinoRepository.findById(viagemDto.destinoId());
        if (destinoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        BeanUtils.copyProperties(viagemDto, viagem);
        viagem.setDestino(destinoOpt.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(viagemRepository.save(viagem));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteViagem(@PathVariable(value="id") Long id){
        Optional<ViagensModel> viagem0 = viagemRepository.findById(id);
        if(viagem0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Viagem nao encontrada");
        }else {
            viagemRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Viagem excluida com sucesso!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateViagem(@PathVariable(value = "id") Long id, @RequestBody @Valid ViagensRecordDto viagemRecordDto){
        Optional<ViagensModel> viagem0 = viagemRepository.findById(id);
        if(viagem0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product nao encontrado");
        }else {
            var productModel = viagem0.get();
            BeanUtils.copyProperties(viagemRecordDto, productModel);
            return ResponseEntity.status(HttpStatus.OK).body(viagemRepository.save(productModel));
        }
    }

    @GetMapping("/destinos/{destinoId}/viagens")
    public ResponseEntity<List<ViagensModel>> getViagensByDestinoId(@PathVariable Long destinoId) {
        var destinoOpt = destinoRepository.findById(destinoId);
        if (destinoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<ViagensModel> viagens = viagemRepository.findByDestinoId(destinoId);
        return ResponseEntity.ok(viagens);
    }
}
