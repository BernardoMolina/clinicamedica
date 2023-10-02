package br.sci.clinicamedica.model.receita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
}
