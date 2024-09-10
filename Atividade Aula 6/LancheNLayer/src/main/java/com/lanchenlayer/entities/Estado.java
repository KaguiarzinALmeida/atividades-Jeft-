package com.lanchenlayer.entities;

public class Estado {
    private int ddd;
    private String nome;
    private String imagem;

    public Estado(int ddd, String nome, String imagem) {
        this.ddd = ddd;
        this.nome = nome;
        this.imagem = imagem;
    }


    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
