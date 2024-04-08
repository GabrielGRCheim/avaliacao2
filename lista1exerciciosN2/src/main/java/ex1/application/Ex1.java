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
package ex1.application;

import ex1.entities.Estudantes;
import java.util.Scanner;


/**
 *
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 08/04/2024
 * @brief Class Ex1
 */
public class Ex1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estudantes[] vect = new Estudantes[9];

        System.out.println("quantos estudades vão se resgistrar?");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.println("Em qual quarto o estudante ficará?");
                int Quarto = sc.nextInt();
                sc.nextLine();
                if (vect[Quarto] != null) {
                    System.out.println("Esse quarto já esta ocupado\n" + "Tente novamente:");
                } else {
                    System.out.println("Digite o nome do estudante:");
                    String nome = sc.nextLine();
                    System.out.println("Digite o email do estudante:");
                    String email = sc.nextLine();
                    vect[Quarto] = new Estudantes(nome, email, Quarto);
                    System.out.println("Estudante resgistrado com sucesso!\n" + "- - - - - - - - - - - - - - - - -");
                    break;
                }
            }
        }
        System.out.println("Busy rooms :");
        for (Estudantes vect1 : vect) {
            if (vect1 != null) {
                System.out.println(vect1);

            }
        }
    }
}
