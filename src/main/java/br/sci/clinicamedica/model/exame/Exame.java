package br.sci.clinicamedica.model.exame;

import br.sci.clinicamedica.model.Status;
import br.sci.clinicamedica.model.medico.Medico;
import br.sci.clinicamedica.model.paciente.Paciente;
import br.sci.clinicamedica.model.receita.Receita;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "exames")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exame {

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
    @DateTimeFormat
    private String dataexame;

    @NotBlank
    @DateTimeFormat
    private String horaexame;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;


    private String resultado;

}
