package br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Entity
@Table(name="TIPO")
@Data
@Builder
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_TIPO", nullable = false)
    private Long id;

    @Column(name="NM_TIPO", nullable = false)
    private String nmTipo;

    @JsonIgnore
    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL)
    private List<Endereco> listEndereco;

    public Tipo(Long id, String nmTipo, List<Endereco> listEndereco) {
        this.id = id;
        this.nmTipo = nmTipo;
        this.listEndereco = listEndereco;
    }

    public Tipo() {}
}
