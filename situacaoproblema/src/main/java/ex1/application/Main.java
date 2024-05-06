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

import java.util.Scanner;

/**
 *
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 06/05/2024
 * @brief Class Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1, x2, x3, y1, y2, y3, coli, dist;

        System.out.println("Digite o valor do ponto x1:");
        x1 = sc.nextInt();
        System.out.println("Digite o valor do ponto y1:");
        y1 = sc.nextInt();
        System.out.println("Digite o valor do ponto x2:");
        x2 = sc.nextInt();
        System.out.println("Digite o valor do ponto y2:");
        y2 = sc.nextInt();
        System.out.println("Digite o valor do ponto x3:");
        x3 = sc.nextInt();
        System.out.println("Digite o valor do ponto y3:");
        y3 = sc.nextInt();
        
        
        
        
        coli = x1*y2*1+y1*1*x3+1*x2*y3-1*y2*x3-y1*x2*1-x1*1*y3;
        
        if (coli == 0){
            dist = (int) Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
            System.out.println("Dista entre o primeiro e o segundo ponto: " + dist);
        }else if(coli != 0){
            System.out.println("Os pontos não estam alinhados");
        }
        
    }

}
