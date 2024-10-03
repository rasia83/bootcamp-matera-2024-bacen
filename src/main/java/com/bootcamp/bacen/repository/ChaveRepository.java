package com.bootcamp.bacen.repository;

import com.bootcamp.bacen.model.Chave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChaveRepository extends JpaRepository<Chave, UUID> {


    Optional<Chave> findByChave(String chavePesquisada);

    boolean existsByChave(final String chave);
}
