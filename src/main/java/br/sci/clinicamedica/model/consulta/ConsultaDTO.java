package br.sci.clinicamedica.model.consulta;

import br.sci.clinicamedica.model.medico.Medico;
import br.sci.clinicamedica.model.paciente.Paciente;
import br.sci.clinicamedica.model.paciente.PacienteDTO;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ConsultaDTO {



    String getStatus();

    String getNomepaciente();

    String getNomemedico();

    String getDatavalidade();

    String getMedicamento();

    String getInstrucoes();

    String getDosagem();


    String getDataconsulta();

    String getHoraconsulta();
}
