package com.lanchenlayer.repositories;

import com.lanchenlayer.entities.Estado;
import java.util.List;

public interface IEstadoRepository {
    void adicionar(Estado estado);
    void atualizar(int ddd, Estado estado);
    List<Estado> buscarTodos();
    Estado buscarPorDdd(int ddd);
    void remover(int ddd);
}
