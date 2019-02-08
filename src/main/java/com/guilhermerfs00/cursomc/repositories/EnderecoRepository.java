package com.guilhermerfs00.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guilhermerfs00.cursomc.domain.Endereco;;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
