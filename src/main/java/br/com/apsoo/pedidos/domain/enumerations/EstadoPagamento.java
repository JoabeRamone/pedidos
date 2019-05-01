package br.com.apsoo.pedidos.domain.enumerations;

public enum EstadoPagamento {

    PENDENTE("Pendente"),
    QUITADO("Quitado"),
    CANCELADO("Cancelado");


    private String descricao;

    private EstadoPagamento(String descrisao){
        this.descricao = descrisao;
    }


    public String getDescricao() {
        return descricao;
    }
}
