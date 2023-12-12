package br.sci.clinicamedica.model.exame;

public interface SalvarExameDTO {

    int getId();

    String getDataexame();

    String getHoraexame();

    int getMedico();

    int getPaciente();

    String getStatus();
}
