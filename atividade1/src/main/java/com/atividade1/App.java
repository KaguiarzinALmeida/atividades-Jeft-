package com.atividade1;

import java.util.List;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        AddProduto adicionar = new AddProduto();

        while (true) {
            System.out.println("         MENU");
            System.out.println("1- Cadastrar Produto");
            System.out.println("2- Cardapio");
            System.out.println("3- Vender Produto");
            Scanner scan = new Scanner(System.in);
            int resposta = scan.nextInt();

            switch (resposta) {
                case 1:
                    System.out.println("Digite o codigo desejado para o item");
                    int res1 = scan.nextInt();

                    System.out.println("Digite o nome do item");
                    String res2 = new Scanner(System.in).nextLine();

                    System.out.println("Digite o valor o do item");
                    Double res3 = scan.nextDouble();

                    System.out.println("Adicionar caminho da imagem");

                    adicionar.cadastrarProduto();

                    System.out.println("Produto cadastrado");

                case 2:
                    System.out.println("cardapio:");
                    List<Produto> produtos = adicionar.getProdutos();
                    for (Produto produto : produtos) {
                        System.out.println(produto);
                    }
                    break;

                case 3:
                    System.out.print("Código do produto a vender: ");
                    int codigo = scan.nextInt();
                    System.out.print("Quantidade a vender: ");
                    int quantidade = scan.nextInt();

                    System.out.println("Valor total a ser pago é:" );
            }
        }
    }
}