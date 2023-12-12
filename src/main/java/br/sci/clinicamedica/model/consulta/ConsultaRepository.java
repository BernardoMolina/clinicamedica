package br.sci.clinicamedica.model.consulta;

import br.sci.clinicamedica.model.medico.Medico;
import br.sci.clinicamedica.model.paciente.PacienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {


    public Consulta getById(int id);
    public Optional<Consulta> findById(int id);
    @Query(value = "SELECT consultas.id,status,pacientes.nome as nomepaciente,medicos.nome as nomemedico,datavalidade,medicamento,dosagem,instrucoes,dataconsulta,horaconsulta \n" +
            "FROM pacientes,consultas,medicos,receitas,medicamentos where pacientes.id=consultas.idpaciente and\n" +
            "medicos.id=consultas.idmedico and consultas.id=receitas.idconsulta and\n" +
            "receitas.id=medicamentos.idreceita", nativeQuery = true)
    List<ConsultaDTO> findAllDTO();

    @Query(value = "SELECT consultas.id as id,status,pacientes.id as paciente,medicos.id as medico,dataconsulta,horaconsulta \n" +
            "FROM pacientes,consultas,medicos where pacientes.id=consultas.idpaciente and\n" +
            "medicos.id=consultas.idmedico and\n" +
            "consultas.id =:id", nativeQuery = true)
    SalvarConsultaDTO salvarConsulta(@Param("id") int id);
}
