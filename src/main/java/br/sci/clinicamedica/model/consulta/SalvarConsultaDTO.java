package br.sci.clinicamedica.model.consulta;

public interface SalvarConsultaDTO {

    int getId();

    String getPacientes();

    String getMedicos();


    String getStatus();


    String getDataconsulta();

    String getHoraconsulta();
}
