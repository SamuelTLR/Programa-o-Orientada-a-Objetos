/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forma;

/**
 *
 * @author aluno
 */
public class Triangulo extends Forma {   
    private Ponto2D[] pontos;
    private double d1, d2, d3;
    public Triangulo(Ponto2D[] pontos) {
        this.pontos = pontos;
        d1 = pontos[0].calcularDistancia(pontos[1]);
        d2 = pontos[0].calcularDistancia(pontos[2]);
        d3 = pontos[1].calcularDistancia(pontos[2]);
    }
    @Override
    public double calcularArea(Ponto2D[] pontos) {
        double s = 0;
        s = (d1 + d2 + d3) / 2;
        return Math.sqrt(s * (s - d1)*(s - d2)*(s - d3));
    }

    @Override
    public double Perimetro(Ponto2D[] pontos) {
        return (d1 + d2 + d3);
    }
    @Override 
    public Ponto2D[] getPontos() {
        return pontos;
    }
    public String tipoTriangulo() {
        System.out.println("d1 = "+ d1 + " d2 = " + d2 + " d3 = " + d3);
        double tolerancia = 0.0001;
        if(Math.abs(d1 - d2) < tolerancia && Math.abs(d2 - d3) < tolerancia) {
            return "Triangulo Equilatero";
        }
        if(d1 == d3 || d1 == d2 || d2 == d3) {
            return "Triangulo isóceles";
        }
        else {
            return "Triangulo escaleno";
        }
    }

}
