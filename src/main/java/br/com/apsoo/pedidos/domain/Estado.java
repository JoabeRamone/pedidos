package br.com.apsoo.pedidos.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity //classe é uma emtidade
@Table(name = "TB_ESTADO")
@SequenceGenerator(name = "seq_estado")
public class Estado implements Serializable {


    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "ES_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_estado")
    private Long id;


    @Column(name = "ES_NOME")
    private String nome;

    @OneToMany(mappedBy = "estado")//1..*
    private List<Cidade> cidades = new ArrayList<>();

    public Estado() {
    }

    public Estado(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return id == estado.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}

