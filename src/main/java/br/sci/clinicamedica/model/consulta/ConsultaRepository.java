package br.sci.clinicamedica.model.consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}
