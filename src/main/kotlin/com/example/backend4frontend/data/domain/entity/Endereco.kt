package br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Entity
@Table(name="ENDERECO")
@Data
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_ENDERECO", nullable = false)
    private Long id;

    @Column(name="LOGRADOURO", nullable = false)
    private String logradouro;

    @Column(name = "NUMERO", nullable = false)
    private String numero;

    @Column(name = "COMPLEMENTO", nullable = false)
    private String complemento;

    @Column(name = "BAIRRO", nullable = false)
    private String bairro;

    @Column(name = "CIDADE", nullable = false)
    private String cidade;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @ManyToOne
    @JoinTable(
            name = "TIPO_ENDERECO",
            joinColumns = @JoinColumn(name = "ID_ENDERECO"),
            inverseJoinColumns = @JoinColumn(name = "ID_TIPO"))
    private Tipo tipo;

    @JsonIgnore
    @ManyToMany(mappedBy = "listEndereco", cascade = CascadeType.ALL)
    private List<Pessoa> idPessoa;

    public Endereco(Long id, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, Tipo tipo, List<Pessoa> idPessoa) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.tipo = tipo;
        this.idPessoa = idPessoa;
    }

    public Endereco() {}
}
