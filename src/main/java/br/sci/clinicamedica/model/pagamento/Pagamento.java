package br.sci.clinicamedica.model.pagamento;

import br.sci.clinicamedica.model.consulta.Consulta;
import br.sci.clinicamedica.model.exame.Exame;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "pagamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "idconsulta")
    private Consulta consultas;

    @OneToOne
    @JoinColumn(name = "idexame")
    private Exame exames;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FormasDePagamento formadepagamento;


    private float valor;
}
