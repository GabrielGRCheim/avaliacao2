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

package ex1;

/**
 *
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 01/04/2024
 * @brief Class Aluno
 */
public class Aluno {
    private double N1, N2, N3, N4;
    private static int qtdDeAlunos = 0;
    private static double somaDasMedias = 0;

    public Aluno(double N1, double N2, double N3, double N4){
        this.N1 = N1;
        this.N2 = N2;
        this.N3 = N3;
        this.N4 = N4;
        qtdDeAlunos ++;
        somaDasMedias += mediaPonderada();
    }
    
    
    public double getN1(){
        return N1;
    }
    
    public double getN2(){
        return N2;
    }
    
    public double getN3(){
        return N3;
    }
    
    public double getN4(){
        return N4;
    }
    
    public void setN1(double N1){
        this.N1 = N1;
    }
    
    public void setN2(double N2){
        this.N2 = N2;
    }
    
    public void setN3(double N3){
        this.N3 = N3;
    }
    
    public void setN4(double N4){
        this.N4 = N4;
    }
    
    public double mediaPonderada(){
       return (N1 * 1 + N2 * 2 + N3 * 3 + N4 * 4)/10;
    }
    
    public int compararMedia(Aluno proximoAluno) {
        double mediaAluno = proximoAluno.mediaPonderada();
        if (this.mediaPonderada()< mediaAluno) {
            return -1;
        } else if (this.mediaPonderada()> mediaAluno) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public static double mediaDaSala(){
        return somaDasMedias / qtdDeAlunos;
    }
}
