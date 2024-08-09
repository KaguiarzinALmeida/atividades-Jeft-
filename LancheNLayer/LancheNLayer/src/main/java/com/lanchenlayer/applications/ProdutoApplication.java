package com.lanchenlayer.applications;

import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.services.ProdutoService;
import com.lanchenlayer.repositories.ProdutoRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class ProdutoApplication {
    private ProdutoRepository produtoRepository;
    private ProdutoService produtoService;

    public ProdutoApplication(ProdutoRepository produtoRepository, ProdutoService produtoService) {
        this.produtoRepository = produtoRepository;
        this.produtoService = produtoService;
        this.produtoService.setProdutoRepository(produtoRepository);
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Remover Imagem");
            System.out.println("4. Vender Produto");
            System.out.println("5. Listar Produtos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    adicionarProduto(scanner);
                    break;
                case 2:
                    atualizarProduto(scanner);
                    break;
                case 3:
                    removerImagem(scanner);
                    break;
                case 4:
                    venderProduto(scanner);
                    break;
                case 5:
                    listarProdutos();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while(opcao != 6);

        scanner.close();
    }

    private void adicionarProduto(Scanner scanner) {
        System.out.print("Informe o ID do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Informe a descrição do produto: ");
        String descricao = scanner.nextLine();

        System.out.print("Informe o preço do produto: ");
        double preco = scanner.nextDouble();

        System.out.print("Informe o caminho da imagem do produto: ");
        String imagem = scanner.next();

        System.out.print("Informe o estoque do produto: ");
        int estoque = scanner.nextInt();

        Produto produto = new Produto(id, descricao, preco, imagem, estoque);
        produtoService.salvarImagem(produto);
        produtoRepository.adicionar(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private void atualizarProduto(Scanner scanner) {
        System.out.print("Informe o ID do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Informe a nova descrição do produto: ");
        String descricao = scanner.nextLine();

        System.out.print("Informe o novo preço do produto: ");
        double preco = scanner.nextDouble();

        System.out.print("Informe o novo caminho da imagem do produto (ou deixe vazio para manter a mesma): ");
        scanner.nextLine(); // Consumir a quebra de linha
        String imagem = scanner.nextLine();

        if (imagem.isEmpty()) {
            imagem = null; // Não alterar a imagem se o campo estiver vazio
        }

        produtoService.atualizar(produtoRepository.buscarPorId(id), descricao, preco, imagem);
        System.out.println("Produto atualizado com sucesso!");
    }

    private void removerImagem(Scanner scanner) {
        System.out.print("Informe o ID do produto: ");
        int id = scanner.nextInt();

        Produto produto = produtoRepository.buscarPorId(id);
        if (produto != null) {
            produtoService.removerImagem(produto);
            System.out.println("Imagem removida com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void venderProduto(Scanner scanner) {
        System.out.print("Informe o ID do produto: ");
        int id = scanner.nextInt();

        System.out.print("Informe a quantidade a ser vendida: ");
        int quantidade = scanner.nextInt();

        if (produtoService.vender(id, quantidade)) {
            System.out.println("Venda realizada com sucesso!");
        } else {
            System.out.println("Falha na venda.");
        }
    }

    private void listarProdutos() {
        System.out.println("Produtos disponíveis:");
        for (Produto produto : produtoRepository.buscarTodos()) {
            System.out.println(produto.getId() + " - " + produto.getDescricao() + " - Estoque: " + produto.getEstoque());
        }
    }

    public ArrayList<Produto> buscarTodos() {
        return null;
    }

    public Produto buscarPorId(int id) {
        return null;
    }

    public void remover(int id) {
    }

    public void adicionar(Produto produto) {

    }
}
