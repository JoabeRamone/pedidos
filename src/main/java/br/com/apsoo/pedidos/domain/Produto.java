package br.com.apsoo.pedidos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



@Entity //classe é uma emtidade
@Table(name = "TB_PRODUTO")
@SequenceGenerator(name = "seq_produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id //identifica que é o ID
    @Column(name = "PR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_produto")
    private  Integer id;

    @Column(name =  "PR_NOME")
    private String nome;

    @Column(name =  "PR_PRECO")
    private Double preco;

    @JsonIgnore
    @ManyToMany//muitos para muitos
    @JoinTable(name = "TB_PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "PR_ID"),
            inverseJoinColumns = @JoinColumn(name = "CA_ID")

    )

    private List<Categoria> categorias = new ArrayList<>();

    public Produto(){

    }


    public Produto(Integer id, String nome, double preco){
        this.id=id;
        this.nome=nome;
        this.preco=preco;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
