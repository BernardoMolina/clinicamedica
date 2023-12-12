package br.sci.clinicamedica.model.consulta;

public interface SalvarConsultaDTO {

    int getId();

    String getPaciente();

    String getMedico();


    String getStatus();


    String getDataconsulta();

    String getHoraconsulta();
}
