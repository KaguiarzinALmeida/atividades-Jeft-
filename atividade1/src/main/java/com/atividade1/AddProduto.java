package com.atividade1;

import java.util.ArrayList;
import java.util.List;

public class AddProduto {

    private List<Produto> produtos;
    private String nome;
    private double preco;
    private int codigo;
    private int quantidade;

    public void adiconarP() {
        this.produtos = new ArrayList<>();
    }


    public void cadastrarProduto() {

        Produto produto = new Produto(nome, preco,codigo, quantidade);
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}