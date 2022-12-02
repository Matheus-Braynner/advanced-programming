package io.github.matheusbraynner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.matheusbraynner.entities.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}