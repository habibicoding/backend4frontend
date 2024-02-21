package br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name="ESTADO")
@Data
@Builder
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_ESTADO", nullable = false)
    private Long idEstado;

    @Column(name="NM_ESTADO", nullable = false)
    private String nmEstado;

    @Column(name="SG_ESTADO", nullable = false)
    private String sgEstado;

    public Estado(Long idEstado, String nmEstado, String sgEstado) {
        this.idEstado = idEstado;
        this.nmEstado = nmEstado;
        this.sgEstado = sgEstado;
    }

    public Estado() {}
}
