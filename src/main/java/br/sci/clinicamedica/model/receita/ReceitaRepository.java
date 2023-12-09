package br.sci.clinicamedica.model.receita;

import br.sci.clinicamedica.model.consulta.ConsultaDTO;
import br.sci.clinicamedica.model.consulta.SalvarConsultaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ReceitaRepository extends JpaRepository<Receita, Integer> {

    @Query(value = "SELECT receitas.id as id,dataprescricao,datavalidade,idconsulta \n" +
            "FROM receitas where receitas.id =:id\n" , nativeQuery = true)
    SalvarReceitaDTO salvarReceita(@Param("id") int id);

    @Query(value = "SELECT receitas.id,medicamentos.dosagem,medicamentos.instrucoes,medicamentos.medicamento \n" +
            "FROM receitas,medicamentos where \n" +
            "receitas.id=medicamentos.idreceita", nativeQuery = true)
    List<ReceitaDTO> findAllDTO();

}
