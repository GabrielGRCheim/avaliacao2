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

import ex1.entities.PecaImportada;
import java.util.Scanner;

/**
 * 
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 19/04/2024
 * @brief Class MainPeca
 */
public class MainPeca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PecaImportada peca = new PecaImportada();
        
        System.out.println("Digite o nome da Peça: ");
        peca.setNome(sc.nextLine());
        System.out.println("Digite o valor do custo: ");
        peca.setCusto(sc.nextFloat());
        System.out.println("Digite o valor do Lucro: ");
        peca.setLucro(sc.nextFloat());
        System.out.println("Digite o valor da Taxa de Importação: ");
        peca.setTaxaImportacao(sc.nextFloat());
        System.out.println("Digite o valor da Taxa de Frete: ");
        peca.setTaxaFrete(sc.nextFloat());
        
        
        System.out.println(peca.calcularPreco());
        System.out.println(peca.exibir());
    }

}
