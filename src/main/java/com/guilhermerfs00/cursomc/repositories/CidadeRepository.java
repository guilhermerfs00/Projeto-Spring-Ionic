package com.guilhermerfs00.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guilhermerfs00.cursomc.domain.Cidades;

@Repository
public interface CidadeRepository extends JpaRepository<Cidades, Integer> {

}
