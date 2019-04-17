package br.com.apsoo.pedidos.resource.exception;

import java.io.Serializable;

public class StandantError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;
    private String mensagem;
    private Long timeStamp;


    public StandantError(Integer status, String mensagem, Long timeStamp) {
        this.status = status;
        this.mensagem = mensagem;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
