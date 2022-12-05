package io.github.matheusbraynner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.matheusbraynner.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}