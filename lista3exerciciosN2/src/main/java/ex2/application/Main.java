/*
 * Copyright (C) 2024 Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ex2.application;

/**
 * 
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 19/04/2024
 * @brief Class Main
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ex2.entities.Produto;
import ex2.entities.ProdutoEstadual;
import ex2.entities.ProdutoImportado;
import ex2.entities.ProdutoNacional;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<ProdutoEstadual> produtosEstaduais = new ArrayList<>();
    private static final List<ProdutoNacional> produtosNacionais = new ArrayList<>();
    private static final List<ProdutoImportado> produtosImportados = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\nMENU");
            System.out.println("1- Cadastrar Produto Estadual");
            System.out.println("2- Cadastrar Produto Nacional");
            System.out.println("3- Cadastrar Produto Importado");
            System.out.println("4- Exibir Produtos Estaduais");
            System.out.println("5- Exibir Produtos Nacionais");
            System.out.println("6- Exibir Produtos Importados");
            System.out.println("7- Exibir Todos Produtos");
            System.out.println("9- SAIR");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarProdutoEstadual();
                    break;
                case 2:
                    cadastrarProdutoNacional();
                    break;
                case 3:
                    cadastrarProdutoImportado();
                    break;
                case 4:
                    exibirProdutos(produtosEstaduais);
                    break;
                case 5:
                    exibirProdutos(produtosNacionais);
                    break;
                case 6:
                    exibirProdutos(produtosImportados);
                    break;
                case 7:
                    exibirTodosProdutos();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 9);

        scanner.close();
    }

    private static void cadastrarProdutoEstadual() {
        System.out.println("\nCadastro de Produto Estadual");
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor: ");
        float valor = scanner.nextFloat();

        ProdutoEstadual produtoEstadual = new ProdutoEstadual(descricao, valor);
        produtosEstaduais.add(produtoEstadual);

        System.out.println("Produto Estadual cadastrado com sucesso!");
    }

    private static void cadastrarProdutoNacional() {
        System.out.println("\nCadastro de Produto Nacional");
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor: ");
        float valor = scanner.nextFloat();

        ProdutoNacional produtoNacional = new ProdutoNacional(descricao, valor);
        produtosNacionais.add(produtoNacional);

        System.out.println("Produto Nacional cadastrado com sucesso!");
    }

    private static void cadastrarProdutoImportado() {
        System.out.println("\nCadastro de Produto Importado");
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor: ");
        float valor = scanner.nextFloat();

        ProdutoImportado produtoImportado = new ProdutoImportado(descricao, valor);
        produtosImportados.add(produtoImportado);

        System.out.println("Produto Importado cadastrado com sucesso!");
    }

    private static void exibirProdutos(List<? extends Produto> listaProdutos) {
        System.out.println("\nLista de Produtos:");
        for (Produto produto : listaProdutos) {
            produto.relatorio();
        }
    }

    private static void exibirTodosProdutos() {
        System.out.println("\nLista de Produtos Estaduais:");
        exibirProdutos(produtosEstaduais);

        System.out.println("\nLista de Produtos Nacionais:");
        exibirProdutos(produtosNacionais);

        System.out.println("\nLista de Produtos Importados:");
        exibirProdutos(produtosImportados);
    }
}