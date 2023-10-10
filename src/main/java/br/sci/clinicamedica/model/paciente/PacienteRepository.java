package br.sci.clinicamedica.model.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    public Paciente getById(int id);
    public Optional<Paciente> findById(int id);
    @Query(value = "SELECT nome,sobrenome,email,telefone,plano_de_saude FROM pacientes", nativeQuery = true)
    List<PacienteDTO> findAllDTO();


}
