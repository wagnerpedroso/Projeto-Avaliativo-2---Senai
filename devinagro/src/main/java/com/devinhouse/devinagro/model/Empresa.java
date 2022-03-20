package com.devinhouse.devinagro.model;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import javax.persistence.*;

@Data
@Entity
@Table(name="empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nome")
    private String nome;
    @CNPJ
    @Column(name="cnpj")
    private String cnpj;
    @Column(name="endereco")
    private String endereco;
}
