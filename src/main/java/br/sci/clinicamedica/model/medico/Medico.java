package br.sci.clinicamedica.model.medico;

import br.sci.clinicamedica.model.Endereco;
import br.sci.clinicamedica.model.consulta.Consulta;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;


@Entity
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @CPF
    @Size(max = 14,min = 14,message = "CPF deve ter 11 números!!")
    private String cpf;

    @NotBlank
    @Size(max = 14,min = 14,message = "Telefone deve ter 11 números!!")
    private String telefone;

    @NotBlank
    private String especializacao;

    @NotBlank
    @Size(max = 6,min = 6,message = "Registro inválido")
    private String registro;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;
}
