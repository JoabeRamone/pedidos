package br.com.apsoo.pedidos.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "TB_PEDIDO")
@SequenceGenerator(name = "seq_pedido")
public class Pedido implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pedido")
    private Integer id;

    @Column(name = "PE_INSTANTE")
    private Date instante;

    @ManyToOne
    @JoinColumn(name = "CL_ID") //buscar na table de cliente tohdo o objeto cliente
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "EN_ID")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")// mapeie conforme o pedido, o qual atributo ests la no
    private Pagamento pagamento;// pagamento

    public Pedido() {
    }

    public Pedido(Integer id, Date instante, Cliente cliente, Endereco endereco) {
        this.id = id;
        this.instante = instante;
        this.cliente = cliente;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public Date getInstante() {
        return instante;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
