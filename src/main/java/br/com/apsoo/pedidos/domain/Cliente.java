package br.com.apsoo.pedidos.domain;

import br.com.apsoo.pedidos.domain.enumerations.TipoCliente;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;



@Entity //tornar a classe elegivel para entidade no banco de dados.
// Um obt que pode ser trabalhado pela camada de dominio
@Table(name = "TB_CLIENTE")//muda o nome na tabela no banco
@SequenceGenerator(name = "seq_cliente")
public class Cliente implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "CL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_cliente")
    private Integer id;

    @Column(name = "CL_NOME")
    private String nome;

    @Column(name = "CL_EMAIL")
    private String email;

    @Column(name = "CL_CPF_CNPJ")
    private String cpfOuCnpj;

    @Column(name = "CL_TIPO")
    private TipoCliente tipo;

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();



    //elemnto de coleçao é entidade fraca. carrega os dados com o proprio id,
    // ele busca os dados no banco usando o @ElementCollection. Isso significa que ele (telefones)
    // nao é uma entidades
    @ElementCollection
    @CollectionTable(name = "TB_TELEFONE")
    private Set<String> telefones = new HashSet<>();//o set ignora os elemtnos repetidos


    @OneToMany(mappedBy = "cliente")//mapeamento reserso. Ele busca pra ver o precisa. La em pedido
    private List<Pedido> pedidos = new ArrayList<>();




    public Cliente() {
    }

    public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
