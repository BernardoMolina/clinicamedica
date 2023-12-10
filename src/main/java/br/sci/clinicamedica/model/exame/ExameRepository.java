package br.sci.clinicamedica.model.exame;


import br.sci.clinicamedica.model.consulta.Consulta;
import br.sci.clinicamedica.model.consulta.ConsultaDTO;
import br.sci.clinicamedica.model.consulta.SalvarConsultaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExameRepository extends JpaRepository<Exame, Integer> {

    public Optional<Exame> findById(int id);
    @Query(value = "SELECT exames.id,status,pacientes.nome as nomepaciente,medicos.nome as nomemedico,resultado,dataexame,horaexame \n" +
            "FROM pacientes,exames,medicos where pacientes.id=exames.idpaciente and\n" +
            "medicos.id=exames.idmedico " , nativeQuery = true)

    List<ExameDTO> findAllDTO();

    @Query(value = "SELECT exames.id as id,status,pacientes.id as pacientes,medicos.id as medicos,dataexame,horaexame \n" +
            "FROM pacientes,exames,medicos where pacientes.id=exames.idpaciente and\n" +
            "medicos.id=exames.idmedico and\n" +
            "exames.id =:id", nativeQuery = true)
    SalvarExameDTO salvarExame(@Param("id") int id);


}
