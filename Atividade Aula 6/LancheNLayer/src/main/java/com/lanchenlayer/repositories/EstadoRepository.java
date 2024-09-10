package com.lanchenlayer.repositories;

import com.lanchenlayer.entities.Estado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EstadoRepository implements IEstadoRepository {
    private List<Estado> estados = new ArrayList<>();

    @Override
    public void adicionar(Estado estado) {
        estados.add(estado);
    }

    @Override
    public void atualizar(int ddd, Estado estado) {
        Estado estadoInDb = buscarPorDdd(ddd);
        if (estadoInDb != null) {
            estadoInDb.setNome(estado.getNome());
            estadoInDb.setImagem(estado.getImagem());
        }
    }

    @Override
    public List<Estado> buscarTodos() {
        return estados;
    }

    @Override
    public Estado buscarPorDdd(int ddd) {
        Optional<Estado> estado = estados.stream().filter(e -> e.getDdd() == ddd).findFirst();
        return estado.orElse(null);
    }

    @Override
    public void remover(int ddd) {
        estados.removeIf(e -> e.getDdd() == ddd);
    }
}
