/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package forma;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public abstract class Forma {
    private Ponto2D[] pontos;
    public abstract double calcularArea(Ponto2D[] pontos);

    public abstract double Perimetro(Ponto2D[] pontos);

    public static Forma geraForma(Ponto2D[] pontos) {
        if(pontos.length == 2) {
            System.out.println("Gerando círculo...");
            return new Circulo(pontos);
        }
        if(pontos.length == 3) {
            double d1, d2, d3;
            d1 = pontos[0].calcularDistancia(pontos[1]);
            d2 = pontos[0].calcularDistancia(pontos[2]);
            d3 = pontos[1].calcularDistancia(pontos[2]);
            if(d1 + d2 >= d3 && d1 + d3 >= d2 && d2 + d3 >= d1 && d1 > 0 && d2 > 0 && d3 > 0) {
                System.out.println("d1 = "+ d1 + " d2 = " + d2 + " d3 = " + d3);
                System.out.println("Gerando triângulo...");
                return new Triangulo(pontos);
            }
            else {
                System.out.println("Os pontos não formam um triângulo.");
                return null;
            }
        }
        if (pontos.length == 4) {
        double[] lados = new double[4];
        double[] diagonais = new double[2];

        // Calcula os lados
        lados[0] = pontos[0].calcularDistancia(pontos[1]);
        lados[1] = pontos[1].calcularDistancia(pontos[2]);
        lados[2] = pontos[2].calcularDistancia(pontos[3]);
        lados[3] = pontos[3].calcularDistancia(pontos[0]);

        // Calcula as diagonais
        diagonais[0] = pontos[0].calcularDistancia(pontos[2]);
        diagonais[1] = pontos[1].calcularDistancia(pontos[3]);

        // Verifica se todos os lados são iguais
        if (lados[0] != lados[1] || lados[1] != lados[2] || lados[2] != lados[3]) {
            System.out.println("Os pontos não formam um quadrado.");
            return null;
        }

        // Verifica se as diagonais são iguais
        if (diagonais[0] != diagonais[1]) {
            System.out.println("Os pontos não formam um quadrado.");
            return null;
        }

        // Verifica se as diagonais são √2 vezes o lado
        if (diagonais[0] != Math.sqrt(2) * lados[0]) {
            System.out.println("Os pontos não formam um quadrado.");
            return null;
        }

        System.out.println("Gerando quadrado...");
        return new Quadrado(pontos);
    }
        return null;
    }

    public Ponto2D[] getPontos() {
        return pontos;
    }
    public void setPontos(Ponto2D[] pontos) {
        this.pontos = pontos;
    }
}
