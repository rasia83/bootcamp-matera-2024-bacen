package com.bootcamp.bacen.controller;

import com.bootcamp.bacen.dto.ChaveRequestDTO;
import com.bootcamp.bacen.dto.ChaveResponseDTO;
import com.bootcamp.bacen.service.ChaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/api/bacen/chaves")
@RestController
@RequiredArgsConstructor
public class ChaveController {

    private final ChaveService chaveService;

    @PostMapping
    public ResponseEntity<ChaveResponseDTO> criarChave(@RequestBody ChaveRequestDTO chaveRequestDTO){
        return ResponseEntity.status(CREATED).body(chaveService.criarChave(chaveRequestDTO));
    }

    @GetMapping("/{chave}")
    public ResponseEntity<ChaveResponseDTO> conta(@PathVariable String chave) {

        System.out.println("$$$$ controller " + chave);

        return ResponseEntity.status(OK).body(chaveService.buscarChaveByChave(chave));
    }

}
