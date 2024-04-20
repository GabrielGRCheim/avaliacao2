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

package ex3.application;

import ex3.entities.ListaOrdenada;
import java.util.Scanner;

/**
 * 
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 19/04/2024
 * @brief Class MainLista
 */
public class MainLista {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaOrdenada lista = new ListaOrdenada();
        int opcao;
        boolean sair = false;
        do{
            
            System.out.println("Escolha a opção:");
            System.out.println("1 - Adicionar valor\n" + "2 - Remover um valor\n" + "3 - Informar quatidade de números\n" + "4 - Informa valores\n" + "5 - Exibir valores\n" + "6 - Ordenar valores" );
            opcao = sc.nextInt();
            
            switch(opcao) {
                case 1:
                    System.out.println("Informe o valor:");
                    lista.inserirNumero(sc.nextInt());
                    break;
                case 2:
                    lista.removerNumero(opcao);
                    break;
                case 3:
                    System.out.println(lista.informarQtdNumeros());
                    break;
                case 4:
                    lista.informarValores();
                    break;
                case 5:
                    lista.exibirValores();
                    break;
                case 6:
                    lista.ordenarLista();
                    break;
                case 7:
                    sair  = true;
            }
        }while(sair != true);
        
    }
  
}
