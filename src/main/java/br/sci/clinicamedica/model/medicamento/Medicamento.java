package br.sci.clinicamedica.model.medicamento;

import br.sci.clinicamedica.model.consulta.Consulta;
import br.sci.clinicamedica.model.receita.Receita;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medicamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idreceita")
    private Receita receitas;

    private String medicamento;

    private String dosagem;

    private String instrucoes;

}
