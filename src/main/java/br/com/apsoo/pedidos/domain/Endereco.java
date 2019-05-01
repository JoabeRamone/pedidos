package br.com.apsoo.pedidos.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;


@Entity //tornar a classe elegivel para entidade no banco de dados.
// Um obt que pode ser trabalhado pela camada de dominio
@Table(name = "TB_ENDERECO")//muda o nome na tabela no banco
@SequenceGenerator(name = "seq_endereco")
public class Endereco implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "EN_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_endereco")
    private Integer id;//Os registros começam com nulo. Algumas colunas ficam nuulas ao serem criadas

    @Column(name = "EN_LOGRADOURO")
    private String logradouro;

    @Column(name = "EN_NUMERO")
    private String numero;

    @Column(name = "EN_COMPLEMENTO")
    private String complemento;

    @Column(name = "EN_BAIRRO")
    private String bairro;

    @Column(name = "EN_CEP")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "CI_ID")
    private Cidade cidade;

    @JsonBackReference //Carrega o cliente nulo
    @ManyToOne
    @JoinColumn(name = "CL_ID")
    private Cliente cliente;

    public Endereco() {
    }

    public Endereco(Integer id, String logradouro, String numero, String complemento, String bairro, String cep, Cidade cidade, Cliente cliente) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return id.equals(endereco.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
