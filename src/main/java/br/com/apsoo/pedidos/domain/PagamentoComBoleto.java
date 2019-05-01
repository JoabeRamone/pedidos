package br.com.apsoo.pedidos.domain;

import br.com.apsoo.pedidos.domain.enumerations.EstadoPagamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;



@Entity
@Table(name = "TB_PAGAMENTO_COM_BOLETO")
public class PagamentoComBoleto extends Pagamento {


    private static final long serialVersionUID = 1L;

    @Column(name = "PB_DATA_VENCIMENTO")
    private Date dataVencimento;

    @Column(name = "PP_DATA_PAGAMENTO")
    private Date dataPagamento;

    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido); //super é pai, que chama la da clase pagamento
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
