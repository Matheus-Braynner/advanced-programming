package io.github.matheusbraynner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.matheusbraynner.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}