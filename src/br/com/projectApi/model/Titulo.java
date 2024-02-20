package br.com.projectApi.model;

public class Titulo implements Comparable <Titulo>{
    private String titulo;
    private String anoDeLancamento;
    private String autor;


    public Titulo(String titulo, String anoDeLancamento, String autor) {
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public String getAutor() {
        return autor;
    }

    public void exibirDados() {
        System.out.println("Nome do livro: " + getTitulo());
        System.out.println("Ano de lançamento: " + getAnoDeLancamento());
        System.out.println("Nome do Autor(a): " + getAutor());
    }

    @Override
    public String toString() {
        return "titulo =" + titulo + ", anoDeLancamento = " + anoDeLancamento + "," + "autor =" + autor;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getTitulo().compareTo(outroTitulo.getTitulo());
    }}
