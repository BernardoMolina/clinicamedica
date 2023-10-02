package br.sci.clinicamedica.model.medicamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {
}
