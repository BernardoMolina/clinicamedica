package br.sci.clinicamedica.model.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
