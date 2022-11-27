package io.github.matheusbraynner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.matheusbraynner.entities.Feriado;

@Repository
public interface FeriadoRepository extends JpaRepository<Feriado, Long>{

}
