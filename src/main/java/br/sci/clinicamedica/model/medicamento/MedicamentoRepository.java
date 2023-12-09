package br.sci.clinicamedica.model.medicamento;

import br.sci.clinicamedica.model.receita.SalvarReceitaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {

    @Query(value = "SELECT medicamentos.id as id,dosagem,instrucoes,medicamento,idreceita \n" +
            "FROM medicamentos where medicamentos.id =:id\n" , nativeQuery = true)
    SalvarMedicamentoDTO salvarMedicamento(@Param("id") int id);
}
