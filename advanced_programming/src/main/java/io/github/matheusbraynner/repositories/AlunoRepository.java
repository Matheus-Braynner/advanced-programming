package io.github.matheusbraynner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.matheusbraynner.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}