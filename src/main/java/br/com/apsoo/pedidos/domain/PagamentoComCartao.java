package br.com.apsoo.pedidos.domain;

import br.com.apsoo.pedidos.domain.enumerations.EstadoPagamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "TB_PAGAMENTO_COM_CARTAO")
public class PagamentoComCartao extends Pagamento{

    private static final long serialVersionUID = 1L;


    @Column(name = "PC_NUMERO_DE_PARCELAS")
    private Integer numeroDeParcelas;


    public PagamentoComCartao() {

    }

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }


    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
