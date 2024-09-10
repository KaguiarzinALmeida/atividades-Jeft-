package com.lanchenlayer;

import com.lanchenlayer.repositories.EstadoRepository;
import com.lanchenlayer.services.EstadoService;
import com.lanchenlayer.applications.EstadoApplication;

public class Main {
    public static void main(String[] args) {
        EstadoRepository estadoRepository = new EstadoRepository();
        EstadoService estadoService = new EstadoService(estadoRepository);
        EstadoApplication app = new EstadoApplication(estadoService);
        app.iniciar();
    }
}