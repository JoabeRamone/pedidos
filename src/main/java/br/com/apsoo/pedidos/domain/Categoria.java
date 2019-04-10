package br.com.apsoo.pedidos.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity //classe é uma emtidade
@Table(name = "TB_CATEGORIA")
@SequenceGenerator(name = "seq_categoria")
public class Categoria implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id //identifica que é o ID
    @Column(name = "CA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_categoria")
    //o tipo de geração da sequence será automatico
    private Integer id;
    @Column(name =  "CA_NOME")
    private String nome;

    public Categoria(){}

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {

        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
