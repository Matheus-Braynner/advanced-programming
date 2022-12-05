package io.github.matheusbraynner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.matheusbraynner.entities.DiaAula;

@Repository
public interface DiaAulaRepository extends JpaRepository<DiaAula, Long> {

}