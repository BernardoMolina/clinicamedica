package br.sci.clinicamedica.model.receita;

import br.sci.clinicamedica.model.consulta.Consulta;
import br.sci.clinicamedica.model.medicamento.Medicamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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
    private LocalDate data_prescricao;

    @NotBlank
    private LocalDate data_validade;

    @OneToOne
    @JoinColumn(name = "idconsulta")
    private Consulta consulta;

    @OneToMany(mappedBy = "receita")
    private List<Medicamento> medicamentos;

}


