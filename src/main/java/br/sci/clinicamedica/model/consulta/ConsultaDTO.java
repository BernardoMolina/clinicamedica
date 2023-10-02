package br.sci.clinicamedica.model.consulta;

import br.sci.clinicamedica.model.medico.Medico;
import br.sci.clinicamedica.model.paciente.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ConsultaDTO {

    int getID();

    String getSatus();

    Medico getMedico();

    Paciente getPaciente();

    LocalDate getData();

    LocalTime getHora();
}
