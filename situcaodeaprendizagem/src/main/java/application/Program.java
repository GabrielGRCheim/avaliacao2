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

package application;

/**
 * 
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 22/05/2024
 * @brief Class Program
 */
import entities.Vetor;
import java.util.*;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Cria um Scanner para ler a entrada do usuário
        List<Vetor> listaDeVetores = new ArrayList<>(); // Cria uma lista para armazenar os vetores

        int opcao = 0; // Variável para armazenar a opção escolhida pelo usuário

        do {
            boolean entradaValida = false;
            // Exibe o menu de opções
            System.out.println("Selecione uma opção a seguir: \n"
                    + "1- Inserir Vetor \n"
                    + "2- Calcular Magnitude \n"
                    + "3- Calcular Produto Escalar \n"
                    + "4- Determinar Ângulo Entre Vetores \n"
                    + "5- Projetar Vetor \n"
                    + "6- Visualizar Ortogonalidade \n"
                    + "0- Sair");

            // Loop para garantir que a entrada seja um número inteiro válido
            while (!entradaValida) {
                if (sc.hasNextInt()) {
                    opcao = sc.nextInt();
                    entradaValida = true;
                    break;
                } else {
                    System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                    sc.next(); // Limpa a entrada inválida
                }
            }
            sc.nextLine(); // Limpa o buffer

            // Processa a opção escolhida pelo usuário
            switch (opcao) {
                case 1:
                    // Inserir um novo vetor
                    System.out.println("Digite o vetor no formato (2,3) ou (2,3,4):");
                    String input = sc.nextLine();

                    try {
                        Vetor novoVetor = Vetor.lerVetor(input); // Lê e cria o vetor a partir da entrada
                        System.out.println("Vetor lido e inserido: " + novoVetor);
                        listaDeVetores.add(novoVetor); // Adiciona o novo vetor à lista
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }

                    break;

                case 2:
                    // Calcular a magnitude
                    System.out.println("Selecione uma opção: \n"
                            + "1- Calcular magnitude de um único vetor \n"
                            + "2- Calcular magnitude entre dois vetores");
                    int escolha = verificaValor(listaDeVetores);
                    if (escolha == 1) {
                        // Calcular magnitude de um único vetor
                        if (!listaDeVetores.isEmpty()) {
                            System.out.println("Selecione um vetor:");
                            exibirVetores(listaDeVetores); // Exibe a lista de vetores
                            int indexMagnitude = sc.nextInt();
                            Vetor vetorMagnitude = listaDeVetores.get(indexMagnitude - 1);
                            System.out.println("Magnitude do vetor selecionado: " + vetorMagnitude.calcularMagnitude());
                        } else {
                            System.out.println("Nenhum vetor inserido ainda.");
                        }
                    } else if (escolha == 2) {
                        // Calcular magnitude entre dois vetores
                        if (listaDeVetores.size() >= 2) {
                            System.out.println("Escolha dois vetores:");
                            exibirVetores(listaDeVetores); // Exibe a lista de vetores
                            System.out.println("Selecione o primeiro vetor:");
                            int indexVetor1 = verificaValor(listaDeVetores);
                            System.out.println("Selecione o segundo vetor");
                            int indexVetor2 = verificaValor(listaDeVetores);
                            Vetor vetor1 = listaDeVetores.get(indexVetor1 - 1);
                            Vetor vetor2 = listaDeVetores.get(indexVetor2 - 1);
                            double magnitude = Vetor.calcularMagnitudeEntreVetores(vetor1, vetor2);
                            System.out.println("Magnitude entre os vetores selecionados: " + magnitude);
                        } else {
                            System.out.println("Pelo menos dois vetores devem ser inseridos para calcular a magnitude entre eles.");
                        }
                    }
                    break;

                case 3:
                    // Calcular produto escalar
                    if (listaDeVetores.size() >= 2) {
                        System.out.println("Escolha dois vetores:");
                        exibirVetores(listaDeVetores); // Exibe a lista de vetores
                        System.out.println("Selecione o primeiro vetor:");
                        int indexVetor1 = verificaValor(listaDeVetores);
                        System.out.println("Selecione o segundo vetor");
                        int indexVetor2 = verificaValor(listaDeVetores);
                        Vetor vetor1 = listaDeVetores.get(indexVetor1 - 1);
                        Vetor vetor2 = listaDeVetores.get(indexVetor2 - 1);
                        double produtoEscalar = vetor1.calcularProdutoEscalar(vetor2);
                        System.out.println("Produto Escalar: " + produtoEscalar);
                    } else {
                        System.out.println("Pelo menos dois vetores devem ser inseridos para calcular o produto escalar.");
                    }
                    break;

                case 4:
                    // Determinar ângulo entre vetores
                    if (listaDeVetores.size() >= 2) {
                        System.out.println("Escolha dois vetores:");
                        exibirVetores(listaDeVetores); // Exibe a lista de vetores
                        System.out.println("Selecione o primeiro vetor:");
                        int indexVetor1 = verificaValor(listaDeVetores);
                        System.out.println("Selecione o segundo vetor");
                        int indexVetor2 = verificaValor(listaDeVetores);
                        Vetor vetor1 = listaDeVetores.get(indexVetor1 - 1);
                        Vetor vetor2 = listaDeVetores.get(indexVetor2 - 1);
                        double angulo = vetor1.calcularAnguloEntreVetores(vetor1, vetor2);
                        System.out.println("Ângulo entre os vetores selecionados: " + angulo + " graus");
                    } else {
                        System.out.println("Pelo menos dois vetores devem ser inseridos para calcular o ângulo entre eles.");
                    }
                    break;

                case 5:
                    // Projetar vetor
                    if (listaDeVetores.size() >= 2) {
                        System.out.println("Selecione o vetor a ser projetado:");
                        exibirVetores(listaDeVetores); // Exibe a lista de vetores
                        int indexVetorProjecao = verificaValor(listaDeVetores);

                        System.out.println("Selecione o vetor de referência:");
                        exibirVetores(listaDeVetores); // Exibe a lista de vetores
                        int indexVetorReferencia = verificaValor(listaDeVetores);

                        Vetor vetorProjecao = listaDeVetores.get(indexVetorProjecao - 1);
                        Vetor vetorReferencia = listaDeVetores.get(indexVetorReferencia - 1);

                        Vetor projecao = vetorProjecao.projetarSobre(vetorReferencia);

                        System.out.println("Projeção do vetor: " + projecao);
                    } else {
                        System.out.println("Pelo menos dois vetores devem ser inseridos para calcular a projeção.");
                    }
                    break;

                case 6:
                    // Verificar ortogonalidade
                    if (listaDeVetores.size() >= 2) {
                        System.out.println("Escolha dois vetores:");
                        exibirVetores(listaDeVetores); // Exibe a lista de vetores
                        System.out.println("Selecione o primeiro vetor:");
                        int indexVetor1 = verificaValor(listaDeVetores);
                        System.out.println("Selecione o segundo vetor");
                        int indexVetor2 = verificaValor(listaDeVetores);
                        Vetor vetor1 = listaDeVetores.get(indexVetor1 - 1);
                        Vetor vetor2 = listaDeVetores.get(indexVetor2 - 1);
                        boolean saoOrtogonais = vetor1.verificarOrtogonalidade(vetor2);
                        if (saoOrtogonais) {
                            System.out.println("Os vetores selecionados são ortogonais.");
                        } else {
                            System.out.println("Os vetores selecionados não são ortogonais.");
                        }
                    } else {
                        System.out.println("Pelo menos dois vetores devem ser inseridos para verificar a ortogonalidade.");
                    }
                    break;

                case 0:
                    // Sair do programa
                    break;

                default:
                    System.out.println("Opção digitada inválida, tente novamente!");
                    break;
            }
        } while (opcao != 0); // Continua executando até que a opção escolhida seja 0 (Sair)

        sc.close(); // Fecha o Scanner
    }

    // Método para exibir os vetores na lista
    private static void exibirVetores(List<Vetor> listaDeVetores) {
        for (int i = 0; i < listaDeVetores.size(); i++) {
            System.out.println((i + 1) + ": " + listaDeVetores.get(i));
        }
    }

    // Método para verificar e garantir que a entrada seja um valor válido dentro do intervalo de vetores na lista
    private static int verificaValor(List<Vetor> listaDeVetores) {
        Scanner sc = new Scanner(System.in);

        boolean entradaValida = false;
        int valor = 0;

        while (!entradaValida) {
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if ((valor > 0) && (valor < listaDeVetores.size() + 1)) {
                    entradaValida = true;
                } else {
                    System.out.println("Entrada inválida. Por favor, digite um número que esteja contido na lista!.");
                    System.out.println("Tente novamente:");
                }
            } else {
                System.out.println("Digite um valor valido!");
                System.out.println("Tente novamente:");
                sc.next();
            }
        }
        return valor;
    }
}