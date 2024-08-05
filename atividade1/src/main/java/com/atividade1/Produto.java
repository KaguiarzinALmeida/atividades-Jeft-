package com.atividade1;

public class Produto {
    private String nome;
    private int preco;
    private int Codigo;
    private int quantidade;

    public Produto(String nome, double preco, int Codigo, int quantidade){
        this.nome = nome;
        this.preco = (int) preco;
        this.Codigo = Codigo;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void venda(){
        Codigo * quantidade = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", codigo=" + Codigo +
                ", quantidade=" + quantidade +
                '}';
    }
}