package br.com.projectApi.principal;

import br.com.projectApi.model.ConsumoApi;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConsumoApi consumo = new ConsumoApi();
        consumo.obterDados();
    }
}
