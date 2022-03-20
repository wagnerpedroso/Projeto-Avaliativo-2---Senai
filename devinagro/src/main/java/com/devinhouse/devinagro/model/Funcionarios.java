package com.devinhouse.devinagro.model;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;

@Data
@Entity
@Table(name="Funcionarios")
public class Funcionarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nome")
    private String nome;
    @Column(name="sobrenome")
    private String sobrenome;
    @CPF
    @Column(name="cpf")
    private String cpf;
    @Column(name="endereco")
    private String endereco;
    //@Pattern(regexp = "//Rejex Telenone")
    @Column(name="telefone")
    private String telefone;
    @Column(name="sexo")
    private String sexo;
    @Column(name="dataNacimento")
    private String dataNascimento;
    @Column(name="dataContratacao")
    private String dataContratacao;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}



