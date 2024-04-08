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

import ex2.entities.Funcionarios;
import java.util.Scanner;


/**
 *
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 08/04/2024
 * @brief Class Ex2
 */
public class Ex2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o número de funcionarios que será registrado: ");
        int n = sc.nextInt();
        Funcionarios[] func = new Funcionarios[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Digite o Identificador do funcinario:");
            int identificador = sc.nextInt();
            sc.nextLine();
            System.out.println("Digite o Nome do funcionario: ");
            String nome = sc.nextLine();
            System.out.println("Digite o valor do Salario do funcionario: ");
            double salario = sc.nextDouble();
            func[i] = new Funcionarios(identificador, nome, salario);
            System.out.println("Funcionario Registrado com sucesso!\n" + "- - - - - - - - - - - - - - - - - - - -");
        }
        System.out.println("Digite o identificador do funcionario que recebera aumento:");
        int identificador = sc.nextInt();
        boolean verifica = false;

        for (Funcionarios func1 : func) {
            if (identificador == func1.getId()) {
                verifica = true;
            }
        }
        if (verifica == false) {
            System.out.println("Esse Identificador não existe!!\n");
        } else if (verifica == true) {
            System.out.println("Digite o ´percentual de a ser aumentado:");
            double porcentagem = sc.nextDouble();

            for (Funcionarios func1 : func) {
                if (identificador == func1.getId()) {
                    func1.increaseSalary(porcentagem);
                    System.out.println("Salário alterado com sucesso");
                }
            }
        }
        System.out.println("List of employees: ");
        for (Funcionarios func1 : func) {
            System.out.println(func1);
        }
    }

}
