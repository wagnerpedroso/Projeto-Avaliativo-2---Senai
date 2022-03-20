package com.devinhouse.devinagro.model;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="Grao")
public class Grao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nome")
    private String nome;
    @Column(name="tempoColheita")
    private String tempoColheita;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
