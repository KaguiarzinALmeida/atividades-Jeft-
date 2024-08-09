package com.lanchenlayer.services;

import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.repositories.ProdutoRepository;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ProdutoService {
    private String caminhoDestino = "C:\\Users\\aluno\\LancheNLayer\\src\\main\\resources\\images\\";

    public static String getFileExtension(String filePath) {
        String fileName = new File(filePath).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "No extension" : fileName.substring(dotIndex + 1);
    }

    public boolean salvarImagem(Produto produto) {
        Path path = Paths.get(produto.getImagem());

        Path pastaDestino = Paths.get(String.format("%s%d.%s", caminhoDestino, produto.getId(), getFileExtension(produto.getImagem())));

        if (Files.exists(path)) {
            try {
                Files.copy(path, pastaDestino, StandardCopyOption.REPLACE_EXISTING);
                produto.setImagem(pastaDestino.getFileName().toString());
                return true;
            } catch (Exception ex)
            {
                return false;
            }
        }

        return false;
    }


    public boolean removerImagem(Produto produto) {
        Path path = Paths.get(caminhoDestino + produto.getImagem());

        if (Files.exists(path)) {
            try {
                Files.delete(path);
                produto.setImagem(null); // Removendo a referência à imagem no produto
                return true;
            } catch (Exception ex) {
                return false;
            }
        }

        return false; // Se a imagem não existir, retornar falso
    }

    // Novo método: Atualizar
    public boolean atualizar(Produto produto, String novaDescricao, double novoPreco, String novaImagem) {
        produto.setDescricao(novaDescricao);
        produto.setPreco(novoPreco);

        if (novaImagem != null && !novaImagem.isEmpty()) {

            return salvarImagem(produto);
        } else {
            return true;
        }
    }

    public boolean vender(int id, int quantidade) {
        return false;
    }

    public void setProdutoRepository(ProdutoRepository produtoRepository) {

    }
}

