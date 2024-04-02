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

package ex4;

/**
 * @author Rodrigo Ramos <rodrigoramos.rr221@gmail.com>
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 01/04/2024
 * @brief Class MainCafe
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rodrigo Ramos <rodrigoramos.rr221@gmail.com>
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 */
public class MainCafe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Café Expresso", 0.75));
        produtos.add(new Produto("Café Capuccino", 1.00));
        produtos.add(new Produto("Leite com Café", 1.25));
        produtos.add(new Produto("Achocolatado", 1.50));
        produtos.add(new Produto("Bolo de cenoura", 2.00));
        produtos.add(new Produto("Pão de queijo", 1.75));

        int opcao;
        do {
            System.out.println("Forneça uma opção: \n" +
                    "1 - Café Expresso \n" +
                    "2 - Café Capuccino \n" +
                    "3 - Leite com Café \n" +
                    "4 - Achocolatado \n" +
                    "5 - Bolo de cenoura \n" +
                    "6 - Pão de queijo \n" +
                    "7 - Totalizar vendas \n" +
                    "8 - Pagar conta parcial \n" +
                    "9 - Pagar conta total \n" +
                    "10 - Sair");

            opcao = sc.nextInt();

            if (opcao >= 1 && opcao <= 6) {
                produtos.get(opcao - 1).adicionar();
            } else if (opcao == 7) {
                System.out.println("Total de vendas:");
                for (Produto produto : produtos) {
                    System.out.println(produto.getNome() + ": " + produto.getQuantidade() + " - Valor: " + produto.getTotal());
                }
            } else if (opcao == 8) {
                double total = 0;
                System.out.println("Total a pagar:");
                for (Produto produto : produtos) {
                    total += produto.getTotal();
                }
                System.out.println("Total: " + total);

            } else if (opcao == 9) {
                double total = 0;
                System.out.println("Total a pagar:");
                for (Produto produto : produtos) {
                    total += produto.getTotal();
                }
                System.out.println("Total: " + total);
                System.out.println("Conta paga com sucesso!");
                produtos.clear();
            } else if (opcao == 10) {
                double total = 0;
                for (Produto produto : produtos) {
                    total += produto.getTotal();
                }
                if (total > 0) {
                    System.out.println("A conta está em aberto. Por favor, pague antes de sair.");
                    opcao = 0;
                }
            } else {
                System.out.println("Opção inválida");
            }

        } while (opcao != 10);
    }
}
