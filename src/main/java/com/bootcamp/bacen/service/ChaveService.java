package com.bootcamp.bacen.service;

import com.bootcamp.bacen.dto.ChaveRequestDTO;
import com.bootcamp.bacen.dto.ChaveResponseDTO;
import com.bootcamp.bacen.exception.ChaveJaCadastradaException;
import com.bootcamp.bacen.exception.ChaveNaoLocalizadaException;
import com.bootcamp.bacen.model.Chave;
import com.bootcamp.bacen.repository.ChaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChaveService {

    private final ChaveRepository chaveRepository;

    public ChaveResponseDTO criarChave(final ChaveRequestDTO chaveRequestDTO){

        if(chaveRepository.existsByChave(chaveRequestDTO.getChave())){
            throw new ChaveJaCadastradaException(String.format("Chave: %s, já cadastrada no bacen.", chaveRequestDTO.getChave()));
        }

        Chave chave = Chave.builder()
                .chave(chaveRequestDTO.getChave())
                .ativa(chaveRequestDTO.getAtiva())
                .build();

        chave = chaveRepository.save(chave);

        return ChaveResponseDTO.builder()
                .chave(chave.getChave())
                .ativa(chave.getAtiva())
                .build();
    }

    public ChaveResponseDTO buscarChaveByChave(final String chavePesquisada){

        System.out.println("$$$$ service " + chavePesquisada);

        Chave chave = chaveRepository.findByChave(chavePesquisada)
                .orElseThrow(() -> new ChaveNaoLocalizadaException(String.format("Chave: %s, não foi localizada no bacen.", chavePesquisada)));

        return ChaveResponseDTO.builder()
                .chave(chave.getChave())
                .ativa(chave.getAtiva())
                .build();
    }
}
