package br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name="TIPO_ENDERECO")
@Data
@Builder
public class TipoEndereco implements Serializable {

    @Id
    @Column(name="ID_ENDERECO", nullable = false)
    private Long idEndereco;

    @Id
    @Column(name="ID_TIPO", nullable = false)
    private Long idTipo;

}
