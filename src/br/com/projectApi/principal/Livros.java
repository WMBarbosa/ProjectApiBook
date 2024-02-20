package br.com.projectApi.principal;

import br.com.projectApi.model.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Livros {

    public static void main(String[] args) {

        Titulo titulo1 = new Titulo("Coraline", "2002-02-07", "Niel Riddell");
        titulo1.exibirDados();

        Titulo titulo2 = new Titulo("Sherlock Holmes o Cão dos Baskervilles", "1902-25-03", "Arthur Conan Doyle");
        titulo2.exibirDados();

        Titulo titulo3 = new Titulo("Percy Jackson O Último Olimpiano", "2009-05-05", "Rick Riordan");
        titulo3.exibirDados();

        System.out.println();

        List<Titulo> listaDeLivros = new ArrayList<>();
        listaDeLivros.add(titulo1);
        listaDeLivros.add(titulo2);
        listaDeLivros.add(titulo3);
        System.out.println(listaDeLivros);

        System.out.println();

        Collections.sort(listaDeLivros);
        System.out.println("Lista de Livros ordenadas");
        System.out.println(listaDeLivros);

        System.out.println();

        listaDeLivros.sort(Comparator.comparing(Titulo :: getAnoDeLancamento));
        System.out.println("Livros ordenadas por ano de lançamento");
        System.out.println(listaDeLivros);

    }
}
