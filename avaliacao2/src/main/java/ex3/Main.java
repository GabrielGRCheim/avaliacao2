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

package ex3;

import java.util.Scanner;

/**
 * @author Rodrigo Ramos <rodrigoramos.rr221@gmail.com>
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 01/04/2024
 * @brief Class Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o nome do Primeiro Movie:");
        String nomeMovie1 = sc.nextLine();
        System.out.println("Digite o nome do diretor: ");
        String movieDiretor1 = sc.nextLine();
        System.out.println("Digite o preço do movie: ");
        Double moviePrice1 = sc.nextDouble();
        System.out.println("Digite o número de copias: ");
        int movieCopies1 = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o nome do Segundo Movie:");
        String nomeMovie2 = sc.nextLine();
        System.out.println("Digite o nome do diretor: ");
        String movieDiretor2 = sc.nextLine();
        System.out.println("Digite o preço do movie: ");
        Double moviePrice2 = sc.nextDouble();
        System.out.println("Digite o número de copias: ");
        int movieCopies2 = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Digite o nome do Primeiro Album:");
        String nomeAlbum1 = sc.nextLine();
        System.out.println("Digite o nome do diretor: ");
        String albumArtist1 = sc.nextLine();
        System.out.println("Digite o preço do movie: ");
        Double albumPrice1 = sc.nextDouble();
        System.out.println("Digite o número de copias: ");
        int albumCopies1 = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Digite o nome do Segundo Album:");
        String nomeAlbum2 = sc.nextLine();
        System.out.println("Digite o nome do diretor: ");
        String albumArtist2 = sc.nextLine();
        System.out.println("Digite o preço do movie: ");
        Double albumPrice2 = sc.nextDouble();
        System.out.println("Digite o número de copias: ");
        int albumCopies2 = sc.nextInt();
        sc.nextLine();
        
        Movie movie1 = new Movie(nomeMovie1, movieDiretor1, moviePrice1, movieCopies1);
        Movie movie2 = new Movie(nomeMovie2, movieDiretor2, moviePrice2, movieCopies2);
        Album album1 = new Album(nomeAlbum1, albumArtist1, albumPrice1, albumCopies1);
        Album album2 = new Album(nomeAlbum2, albumArtist2, albumPrice2, albumCopies2);
        
        System.out.println("Mostrar informações:");
        System.out.println(movie1);
        movie2.toString();
        album1.toString();
        album2.toString();
        
        sc.close();
    }
}
