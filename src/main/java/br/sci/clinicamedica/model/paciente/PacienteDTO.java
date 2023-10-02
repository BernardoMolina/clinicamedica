package br.sci.clinicamedica.model.paciente;

public interface PacienteDTO {

    int getId();

    String getNome();

    String getSobrenome();

    String getEmail();

    String getCpf();

    String getTelefone();

    String getPlano_de_saude();
}
