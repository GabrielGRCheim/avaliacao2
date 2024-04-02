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

package ex2;

/**
 * @author Rodrigo Ramos <rodrigoramos.rr221@gmail.com>
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 01/04/2024
 * @brief Class JogoDoNumeroSecreto
 */
class JogoDoNumeroSecreto {
    private NumeroSecreto numeroSecreto;

    public JogoDoNumeroSecreto() {
        this.numeroSecreto = new NumeroSecreto();
        this.numeroSecreto.sortear();
    }

    public void jogar() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            System.out.print("Digite seu palpite: ");
            int palpite = scanner.nextInt();
            int resultado = this.numeroSecreto.adivinhar(palpite);

            if (resultado == -2) {
                System.out.println("Você precisa sortear o número secreto primeiro.");
            } else if (resultado == -1) {
                System.out.println("O número secreto é maior.");
            } else if (resultado == 0) {
                System.out.println("Parabéns! Você adivinhou o número secreto!");
                break;
            } else {
                System.out.println("O número secreto é menor.");
            }
        }
        scanner.close();
    }
}
