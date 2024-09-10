package com.lanchenlayer.services;

import com.lanchenlayer.entities.Estado;
import com.lanchenlayer.repositories.IEstadoRepository;

import java.io.File;

public class EstadoService {
    private IEstadoRepository estadoRepository;

    public EstadoService(IEstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public void salvarEstadoComImagem(Estado estado) {
        estadoRepository.adicionar(estado);
        salvarImagem(estado.getImagem());
    }

    public void atualizarEstado(int ddd, Estado estado) {
        estadoRepository.atualizar(ddd, estado);
        atualizarImagem(estado.getImagem());
    }

    private void salvarImagem(String caminhoImagem) {

        File file = new File(caminhoImagem);
        if (file.exists()) {
            System.out.println("Imagem salva com sucesso: " + caminhoImagem);
        } else {
            System.out.println("Imagem não encontrada: " + caminhoImagem);
        }
    }

    private void atualizarImagem(String caminhoImagem) {

        System.out.println("Imagem atualizada: " + caminhoImagem);
    }

    public void removerEstado(int ddd) {
        estadoRepository.remover(ddd);
        removerImagem(ddd);
    }

    private void removerImagem(int ddd) {

        System.out.println("Imagem do estado com DDD " + ddd + " foi removida.");
    }

    public Iterable<Object> buscarTodos() {
        return null;
    }

    public Estado buscarPorDdd(int ddd) {
        return null;
    }
}