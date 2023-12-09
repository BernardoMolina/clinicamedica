package br.sci.clinicamedica.model.consulta;

import br.sci.clinicamedica.model.medicamento.Medicamento;
import br.sci.clinicamedica.model.medico.Medico;
import br.sci.clinicamedica.model.paciente.Paciente;
import br.sci.clinicamedica.model.paciente.PacienteDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ConsultaDTO {


    int getId();
    String getStatus();

    String getNomepaciente();

    String getNomemedico();

    String getDatavalidade();

    String getDataconsulta();

    String getHoraconsulta();


}
