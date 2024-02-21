package br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name="CIDADE")
@Data
@Builder
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CIDADE", nullable = false)
    private Long idCidade;

    @Column(name="NM_CIDADE", nullable = false)
    private String nmCidade;

    @Column(name="SG_CIDADE", nullable = false)
    private String sgCidade;

    public Cidade(Long idCidade, String nmCidade, String sgCidade) {
        this.idCidade = idCidade;
        this.nmCidade = nmCidade;
        this.sgCidade = sgCidade;
    }

    public Cidade(){}
}
