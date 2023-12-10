package br.sci.clinicamedica.model.paciente;

import br.sci.clinicamedica.model.consulta.ConsultaDTO;
import br.sci.clinicamedica.model.consulta.TodasConsultasDTO;
import br.sci.clinicamedica.model.exame.ExameDTO;
import br.sci.clinicamedica.model.exame.TodosExamesDTO;
import br.sci.clinicamedica.model.medico.SalvarMedicoDTO;
import br.sci.clinicamedica.model.receita.ReceitaDTO;
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

    @Query(value = "SELECT * \n" +
            "FROM pacientes where pacientes.id =:id", nativeQuery = true)
    SalvarPacienteDTO salvarPaciente(@Param("id") int id);


    @Query(value = "SELECT consultas.id,medicamento,dosagem,instrucoes \n" +
            "FROM consultas,medicos,receitas,medicamentos where \n" +
            "medicos.id=consultas.idmedico and consultas.id=receitas.idconsulta and status='Concluído'\n" +
            " and receitas.id=medicamentos.idreceita and consultas.idpaciente =:id", nativeQuery = true)
    List<ReceitaDTO> findByReceitasPorPaciente(@Param("id") int id);

    @Query(value = "SELECT consultas.id,status,pacientes.nome as nomepaciente,medicos.nome as nomemedico,datavalidade,dataconsulta,horaconsulta \n" +
            "FROM pacientes,consultas,medicos,receitas where pacientes.id=consultas.idpaciente and\n" +
            "medicos.id=consultas.idmedico and consultas.id=receitas.idconsulta and status='Concluído'\n" +
            " and consultas.idpaciente =:id", nativeQuery = true)
    List<ConsultaDTO> findByConsultasPorPaciente(@Param("id") int id);

    @Query(value = "SELECT status,pacientes.nome as nomepaciente,medicos.nome as nomemedico,dataconsulta,horaconsulta \n" +
            "FROM pacientes,consultas,medicos where pacientes.id=consultas.idpaciente and\n" +
            "medicos.id=consultas.idmedico\n" +
            " and consultas.idpaciente =:id", nativeQuery = true)
    List<TodasConsultasDTO> findByTodasConsultasPorPaciente(@Param("id") int id);



    @Query(value = "SELECT exames.id,status,pacientes.nome as nomepaciente,medicos.nome as nomemedico,dataexame,horaexame,resultado \n" +
            "FROM pacientes,exames,medicos where pacientes.id=exames.idpaciente and\n" +
            "medicos.id=exames.idmedico and status='Concluído'\n" +
            " and exames.idpaciente =:id", nativeQuery = true)
    List<ExameDTO> findByExamesPorPaciente(@Param("id") int id);
    @Query(value = "SELECT status,pacientes.nome as nomepaciente,medicos.nome as nomemedico,dataexame,horaexame \n" +
            "FROM pacientes,exames,medicos where pacientes.id=exames.idpaciente and\n" +
            "medicos.id=exames.idmedico\n" +
            " and exames.idpaciente =:id", nativeQuery = true)
    List<TodosExamesDTO> findByTodasExamesPorPaciente(@Param("id") int id);


}
