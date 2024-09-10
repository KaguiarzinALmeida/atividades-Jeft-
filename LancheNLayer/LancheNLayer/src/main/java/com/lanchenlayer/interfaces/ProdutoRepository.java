package com.lanchenlayer.interfaces;

import com.lanchenlayer.entities.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository implements IProdutoRepository {
    private ArrayList<Produto> produtos = new ArrayList<>();

    @Override
    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public void remover(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    private Produto filtrarProduto(int id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Produto buscarPorId(int id) {
        return filtrarProduto(id);
    }

    @Override
    public List<Produto> buscarTodos() {
        return produtos;
    }

    @Override
    public void atualizarProduto(int id, Produto produto) {
        Produto produtoInDb = filtrarProduto(id);
        if (produtoInDb != null) {
            produtoInDb.setDescricao(produto.getDescricao());
            produtoInDb.setValor(produto.getValor());
            produtoInDb.setImagem(produto.getImagem());
        }
    }
}