package br.com.apsoo.pedidos.domain;

import br.com.apsoo.pedidos.domain.enumerations.EstadoPagamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;




@Entity
@Table(name = "TB_PAGAMENTO")
@SequenceGenerator(name = "seq_pagamento")
@Inheritance(strategy = InheritanceType.JOINED)//Herança9
public abstract class Pagamento implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @Column(name = "PA_ESTADO")
    private EstadoPagamento estado;

    @OneToOne
    @MapsId
    @JoinColumn(name = "PE_ID")//Quando ele traz o pagamento ele tb traz o pedido
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
        this.id = id;
        this.estado = estado;
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public EstadoPagamento getEstado() {
        return estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
