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
 * @brief Class NumeroSecreto
 */
import java.util.Random;

class NumeroSecreto {
    private int numeroSecreto;

    public NumeroSecreto() {
        this.numeroSecreto = -1;
    }

    public void sortear() {
        Random random = new Random();
        this.numeroSecreto = random.nextInt(101); // Gera um número aleatório entre 0 e 100
    }

    public int adivinhar(int palpite) {
        if (this.numeroSecreto == -1) {
            return -2;
        } else if (palpite < this.numeroSecreto) {
            return -1;
        } else if (palpite == this.numeroSecreto) {
            return 0;
        } else {
            return 1;
        }
    }
}