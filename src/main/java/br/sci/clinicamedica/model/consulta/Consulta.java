package br.sci.clinicamedica.model.consulta;

import br.sci.clinicamedica.model.medico.Medico;
import br.sci.clinicamedica.model.paciente.Paciente;
import br.sci.clinicamedica.model.receita.Receita;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "consultas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idmedico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "idpaciente")
    private Paciente paciente;



    @NotBlank
    private LocalDate data;

    @NotBlank
    private LocalTime hora;

    @NotBlank
    private String status;

    @OneToOne(mappedBy = "consulta")
    private Receita receita;
}
