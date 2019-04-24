package br.com.apsoo.pedidos.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity //tornar a classe elegivel para entidade no banco de dados.
        // Um obt que pode ser trabalhado pela camada de dominio
@Table(name = "TB_CIDADE")//muda o nome na tabela no banco
@SequenceGenerator(name = "seq_cidade")
public class Cidade implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "CI_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_cidade")
    private Long id;

    @Column(name = "CI_NOME")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ES_ID")
    private Estado estado;

    public Cidade() {
    }


    public Cidade(Long id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return id.equals(cidade.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
