package br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity(name = "pessoa")
@Table(name="PESSOA")
@Data
@Builder
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_PESSOA", nullable = false)
    private Long id;

    @Column(name="NAME", length = 50, nullable = false)
    private String nome;

    @Column(name = "IDADE", length = 3, nullable = false)
    private Integer nrIdade;

    @Column(name = "CPF", length = 11, nullable = false)
    private String nrCpf;

    @Column(name = "TELEFONE", length = 11, nullable = false)
    private String nrTelefone;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ENDERECO_PESSOA",
            joinColumns = @JoinColumn(name = "ID_PESSOA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO"))
    private List<Endereco> listEndereco;

    public Pessoa(Long id, String nome, Integer nrIdade, String nrCpf, String nrTelefone, List<Endereco> listEndereco) {
        this.id = id;
        this.nome = nome;
        this.nrIdade = nrIdade;
        this.nrCpf = nrCpf;
        this.nrTelefone = nrTelefone;
        this.listEndereco = listEndereco;
    }

    public Pessoa() {}
}
