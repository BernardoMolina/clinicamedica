package br.sci.clinicamedica.model.paciente;

import br.sci.clinicamedica.model.consulta.ConsultaDTO;
import br.sci.clinicamedica.model.consulta.TodasConsultasDTO;
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



    @Query(value = "SELECT status,pacientes.nome as nomepaciente,medicos.nome as nomemedico,datavalidade,medicamento,dosagem,instrucoes,dataconsulta,horaconsulta \n" +
            "FROM pacientes,consultas,medicos,receitas,medicamentos where pacientes.id=consultas.idpaciente and\n" +
            "medicos.id=consultas.idmedico and consultas.id=receitas.idconsulta and\n" +
            "receitas.id=medicamentos.idreceita and consultas.idpaciente =:id", nativeQuery = true)
    List<ConsultaDTO> findByConsultasPorPaciente(@Param("id") int id);

    @Query(value = "SELECT status,pacientes.nome as nomepaciente,medicos.nome as nomemedico,dataconsulta,horaconsulta \n" +
            "FROM pacientes,consultas,medicos where pacientes.id=consultas.idpaciente and\n" +
            "medicos.id=consultas.idmedico\n" +
            " and consultas.idpaciente =:id", nativeQuery = true)
    List<TodasConsultasDTO> findByTodasConsultasPorPaciente(@Param("id") int id);


}
