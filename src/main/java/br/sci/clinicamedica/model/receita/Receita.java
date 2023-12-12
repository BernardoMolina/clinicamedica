package br.sci.clinicamedica.model.receita;

import br.sci.clinicamedica.model.consulta.Consulta;
import br.sci.clinicamedica.model.medicamento.Medicamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "receitas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Receita{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String dataprescricao;

    @NotBlank
    private String datavalidade;


    @OneToOne
    @JoinColumn(name = "idconsulta")
    private Consulta consulta;

    @OneToMany(mappedBy = "receita")
    private List<Medicamento> medicamentos;

}


