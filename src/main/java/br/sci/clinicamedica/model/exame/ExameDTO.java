package br.sci.clinicamedica.model.exame;

public interface ExameDTO {

    int getId();
    String getStatus();

    String getNomepaciente();

    String getNomemedico();

    String getDataexame();

    String getHoraexame();

    String getResultado();
}
