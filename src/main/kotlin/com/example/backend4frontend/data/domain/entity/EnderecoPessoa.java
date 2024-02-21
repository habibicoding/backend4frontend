package br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name="ENDERECO_PESSOA")
@Data
@Builder
public class EnderecoPessoa implements Serializable {

    @Id
    @Column(name="ID_PESSOA", nullable = false)
    private Long idPessoa;

    @Id
    @Column(name="ID_ENDERECO", nullable = false)
    private Long idEndereco;

}
