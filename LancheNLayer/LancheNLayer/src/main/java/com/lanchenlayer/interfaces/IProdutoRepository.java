package com.lanchenlayer.interfaces;

import com.lanchenlayer.entities.Produto;
import java.util.List;

public interface IProdutoRepository {
    void adicionar(Produto produto);
    void remover(int id);
    Produto buscarPorId(int id);
    List<Produto> buscarTodos();
    void atualizarProduto(int id, Produto produto);
}
