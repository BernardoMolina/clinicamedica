package br.sci.clinicamedica.model.medico;

import br.sci.clinicamedica.model.consulta.ConsultaDTO;
import br.sci.clinicamedica.model.consulta.SalvarConsultaDTO;
import br.sci.clinicamedica.model.consulta.TodasConsultasDTO;
import br.sci.clinicamedica.model.exame.ExameDTO;
import br.sci.clinicamedica.model.exame.TodosExamesDTO;
import br.sci.clinicamedica.model.paciente.Paciente;
import br.sci.clinicamedica.model.paciente.PacienteDTO;
import br.sci.clinicamedica.model.receita.ReceitaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MedicoRepository extends JpaRepository<Medico, Integer> {


    public Medico getById(int id);
    public Optional<Medico> findById(int id);
    @Query(value = "SELECT nome,sobrenome,email,telefone,especializacao,registro_medico FROM medicos", nativeQuery = true)
    List<MedicoDTO> findAllDTO();

    @Query(value = "SELECT * \n" +
            "FROM medicos where medicos.id =:id", nativeQuery = true)
    SalvarMedicoDTO salvarMedico(@Param("id") int id);

    @Query(value = "SELECT consultas.id,medicamento,dosagem,instrucoes \n" +
            "FROM consultas,medicos,receitas,medicamentos where \n" +
            "medicos.id=consultas.idmedico and consultas.id=receitas.idconsulta and status='Concluído'\n" +
            " and receitas.id=medicamentos.idreceita and consultas.idmedico =:id", nativeQuery = true)
    List<ReceitaDTO> findByReceitasPorMedico(@Param("id") int id);

    @Query(value = "SELECT consultas.id,status,pacientes.nome as nomepaciente,medicos.nome as nomemedico,datavalidade,dataconsulta,horaconsulta \n" +
            "FROM pacientes,consultas,medicos,receitas where pacientes.id=consultas.idpaciente and\n" +
            "medicos.id=consultas.idmedico and consultas.id=receitas.idconsulta and status='Concluído'\n" +
            " and consultas.idmedico =:id", nativeQuery = true)
    List<ConsultaDTO> findByConsultasPorMedico(@Param("id") int id);
    @Query(value = "SELECT status,pacientes.nome as nomepaciente,medicos.nome as nomemedico,dataconsulta,horaconsulta \n" +
            "FROM pacientes,consultas,medicos where pacientes.id=consultas.idpaciente and\n" +
            "medicos.id=consultas.idmedico\n" +
            " and consultas.idmedico =:id", nativeQuery = true)
    List<TodasConsultasDTO> findByTodasConsultasPorMedico(@Param("id") int id);




    @Query(value = "SELECT status,pacientes.nome as nomepaciente,medicos.nome as nomemedico,dataexame,horaexame,resultado \n" +
            "FROM pacientes,exames,medicos where pacientes.id=exames.idpaciente and\n" +
            "medicos.id=exames.idmedico and status='Concluído'\n" +
            " and exames.idmedico =:id", nativeQuery = true)
    List<ExameDTO> findByExamesPorMedico(@Param("id") int id);
    @Query(value = "SELECT status,pacientes.nome as nomepaciente,medicos.nome as nomemedico,dataexame,horaexame \n" +
            "FROM pacientes,exames,medicos where pacientes.id=exames.idpaciente and\n" +
            "medicos.id=exames.idmedico\n" +
            " and exames.idmedico =:id", nativeQuery = true)
    List<TodosExamesDTO> findByTodasExamesPorMedico(@Param("id") int id);

}
