package com.lanchenlayer.applications;

import com.lanchenlayer.entities.Estado;
import com.lanchenlayer.services.EstadoService;

import java.util.Scanner;

public class EstadoApplication {
    private EstadoService estadoService;
    private Scanner scanner = new Scanner(System.in);

    public EstadoApplication(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    public void iniciar() {
        int opcao = -1;
        while (opcao != 6) {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha
            processarOpcao(opcao);
        }
    }

    private void mostrarMenu() {
        System.out.println("\n1 - Novo estado");
        System.out.println("2 - Atualizar estado");
        System.out.println("3 - Listar estados");
        System.out.println("4 - Buscar estado pelo DDD");
        System.out.println("5 - Remover estado");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarEstado();
                break;
            case 2:
                atualizarEstado();
                break;
            case 3:
                listarEstados();
                break;
            case 4:
                buscarEstadoPorDdd();
                break;
            case 5:
                removerEstado();
                break;
            case 6:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void adicionarEstado() {
        System.out.print("Digite o nome do estado: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o DDD: ");
        int ddd = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Digite o caminho da imagem: ");
        String imagem = scanner.nextLine();

        Estado estado = new Estado(ddd, nome, imagem);
        estadoService.salvarEstadoComImagem(estado);
    }

    private void atualizarEstado() {
        System.out.print("Digite o DDD do estado a ser atualizado: ");
        int ddd = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha
        System.out.print("Digite o novo nome do estado: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o novo caminho da imagem: ");
        String imagem = scanner.nextLine();

        Estado estado = new Estado(ddd, nome, imagem);
        estadoService.atualizarEstado(ddd, estado);
    }

    private void listarEstados() {
        estadoService.buscarTodos().forEach(estado -> {
            System.out.println("DDD: " + estado.getClass() + ", Nome: " + estado.getClass() + ", Imagem: " + estado.getClass());
        });
    }

    private void buscarEstadoPorDdd() {
        System.out.print("Digite o DDD do estado: ");
        int ddd = scanner.nextInt();
        Estado estado = estadoService.buscarPorDdd(ddd);
        if (estado != null) {
            System.out.println("DDD: " + estado.getDdd() + ", Nome: " + estado.getNome() + ", Imagem: " + estado.getImagem());
        } else {
            System.out.println("Estado não encontrado.");
        }
    }

    private void removerEstado() {
        System.out.print("Digite o DDD do estado a ser removido: ");
        int ddd = scanner.nextInt();
        estadoService.removerEstado(ddd);
    }
}