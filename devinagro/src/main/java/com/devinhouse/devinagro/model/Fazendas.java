package com.devinhouse.devinagro.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="fazendas")
public class Fazendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nome")
    private String nome;
    @Column(name="endereco")
    private String endereco;
    @Column(name="capacidadeEstoque")
    private Double capacidadeEstoque;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    @JsonFormat(pattern = "dd-MM-aaaa")
    private String ultimaColheita;
    @ManyToOne
    @JoinColumn(name = "grao_id")
    private Grao grao;

}





