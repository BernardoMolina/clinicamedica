package br.sci.clinicamedica.model.pagamento;


import br.sci.clinicamedica.model.medico.SalvarMedicoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

    @Query(value = "SELECT id,valor,pagamentos.idconsulta as consulta,pagamentos.idexame as exame,formadepagamento \n" +
            "FROM pagamentos where pagamentos.id =:id", nativeQuery = true)
    SalvarPagamentoDTO salvarPagamento(@Param("id") int id);
}
