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
import org.springframework.format.annotation.DateTimeFormat;


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
    private Medico medicos;

    @ManyToOne
    @JoinColumn(name = "idpaciente")
    private Paciente pacientes;



    @NotBlank
    @DateTimeFormat
    private String dataconsulta;

    @NotBlank
    @DateTimeFormat
    private String horaconsulta;

    @NotBlank
    private String status;

    @OneToOne(mappedBy = "consultas")
    private Receita receita;
}
