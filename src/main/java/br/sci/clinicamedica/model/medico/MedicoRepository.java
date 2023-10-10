package br.sci.clinicamedica.model.medico;

import br.sci.clinicamedica.model.paciente.Paciente;
import br.sci.clinicamedica.model.paciente.PacienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MedicoRepository extends JpaRepository<Medico, Integer> {


    public Medico getById(int id);
    public Optional<Medico> findById(int id);
    @Query(value = "SELECT nome,sobrenome,email,telefone,especializacao,registro_medico FROM medicos", nativeQuery = true)
    List<MedicoDTO> findAllDTO();

}
