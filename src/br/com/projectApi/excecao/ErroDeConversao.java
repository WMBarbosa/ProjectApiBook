package br.com.projectApi.excecao;

public class ErroDeConversao extends RuntimeException{
    private String mensagem;

    public ErroDeConversao (String mensagem) {
        this.mensagem = mensagem;
    }
    public String getMensagem() {
        return this.mensagem;
    }
}
