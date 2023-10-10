package br.sci.clinicamedica.model.consulta;

import br.sci.clinicamedica.model.paciente.PacienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    @Query(value = "SELECT status,pacientes.nome as nomepaciente,medicos.nome as nomemedico,datavalidade,medicamento,dosagem,instrucoes,dataconsulta,horaconsulta \n" +
            "FROM pacientes,consultas,medicos,receitas,medicamentos where pacientes.id=consultas.idpaciente and\n" +
            "medicos.id=consultas.idmedico and consultas.id=receitas.idconsulta and\n" +
            "receitas.id=medicamentos.idreceita", nativeQuery = true)
    List<ConsultaDTO> findAllDTO();
}
