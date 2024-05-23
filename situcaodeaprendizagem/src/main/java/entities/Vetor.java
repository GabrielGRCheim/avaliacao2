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

package entities;

/**
 * 
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 22/05/2024
 * @brief Class Vetor
 */
public class Vetor {

    // Atributos privados para representar as coordenadas x, y e z do vetor
    private double x;
    private double y;
    private double z;

    // Construtor que inicializa o vetor com valores fornecidos para x, y e z
    public Vetor(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Método estático que lê um vetor a partir de uma string no formato (x,y) ou (x,y,z)
    public static Vetor lerVetor(String input) throws IllegalArgumentException {
        // Remove parênteses e espaços, e divide a string pelos caracteres ',' para obter os valores
        String[] valores = input.replaceAll("[()\\s]", "").split(",");
        
        // Verifica se a quantidade de valores está correta (2 ou 3)
        if (valores.length < 2 || valores.length > 3) {
            throw new IllegalArgumentException("Formato de vetor inválido. Use (x,y) ou (x,y,z).");
        }
        try {
            // Converte os valores de string para double
            double x = Double.parseDouble(valores[0]);
            double y = Double.parseDouble(valores[1]);
            double z = (valores.length == 3) ? Double.parseDouble(valores[2]) : 0.0; // Se não houver z, assume 0.0
            return new Vetor(x, y, z); // Retorna um novo objeto Vetor
        } catch (NumberFormatException e) {
            // Lança uma exceção se algum valor não for um número válido
            throw new IllegalArgumentException("Valores do vetor devem ser números válidos.");
        }
    }

    // Método que retorna uma representação em string do vetor
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    // Método que calcula a magnitude (comprimento) do vetor
    public double calcularMagnitude() {
        return Math.sqrt(x * x + y * y + z * z); // Utiliza a fórmula da distância euclidiana
    }

    // Método que calcula o produto escalar (dot product) entre este vetor e outro vetor fornecido
    public double calcularProdutoEscalar(Vetor outroVetor) {
        return this.x * outroVetor.x + this.y * outroVetor.y + this.z * outroVetor.z;
    }

    // Método que calcula o ângulo entre dois vetores em graus
    public double calcularAnguloEntreVetores(Vetor vetor1, Vetor vetor2) {
        double produtoEscalar = vetor1.calcularProdutoEscalar(vetor2); // Calcula o produto escalar
        double magnitudeVetor1 = vetor1.calcularMagnitude(); // Calcula a magnitude do vetor1
        double magnitudeVetor2 = vetor2.calcularMagnitude(); // Calcula a magnitude do vetor2
        double cosTheta = produtoEscalar / (magnitudeVetor1 * magnitudeVetor2); // Calcula o cosseno do ângulo
        double thetaRad = Math.acos(cosTheta); // Calcula o ângulo em radianos
        double thetaGraus = Math.toDegrees(thetaRad); // Converte o ângulo para graus
        return thetaGraus;
    }

    // Método que projeta este vetor sobre outro vetor fornecido
    public Vetor projetarSobre(Vetor vetor) {
        double produtoEscalar = calcularProdutoEscalar(vetor); // Calcula o produto escalar entre os vetores
        double magnitudeVetor = vetor.calcularMagnitude(); // Calcula a magnitude do vetor fornecido
        double escalar = produtoEscalar / (magnitudeVetor * magnitudeVetor); // Calcula o escalar para a projeção
        double xProjetado = escalar * vetor.x; // Calcula a componente x do vetor projetado
        double yProjetado = escalar * vetor.y; // Calcula a componente y do vetor projetado
        double zProjetado = escalar * vetor.z; // Calcula a componente z do vetor projetado
        return new Vetor(xProjetado, yProjetado, zProjetado); // Retorna um novo vetor que é a projeção
    }

    // Método que verifica se este vetor é ortogonal (perpendicular) a outro vetor fornecido
    public boolean verificarOrtogonalidade(Vetor outroVetor) {
        double produtoEscalar = this.calcularProdutoEscalar(outroVetor); // Calcula o produto escalar
        return produtoEscalar == 0; // Se o produto escalar for zero, os vetores são ortogonais
    }

    // Método estático que calcula a magnitude da diferença entre dois vetores (distância entre eles)
    public static double calcularMagnitudeEntreVetores(Vetor vetor1, Vetor vetor2) {
        double diferencaX = vetor2.x - vetor1.x; // Calcula a diferença das componentes x
        double diferencaY = vetor2.y - vetor1.y; // Calcula a diferença das componentes y
        double diferencaZ = vetor2.z - vetor1.z; // Calcula a diferença das componentes z
        return Math.sqrt(diferencaX * diferencaX + diferencaY * diferencaY + diferencaZ * diferencaZ); // Calcula a distância euclidiana
    }
    
    public Vetor calcularProdutoVetorial(Vetor outroVetor) {
        double x = this.y * outroVetor.z - this.z * outroVetor.y;
        double y = this.z * outroVetor.x - this.x * outroVetor.z;
        double z = this.x * outroVetor.y - this.y * outroVetor.x;
        return new Vetor(x, y, z);
    }
}