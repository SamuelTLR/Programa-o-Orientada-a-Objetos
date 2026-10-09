/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forma;

/**
 *
 * @author aluno
 */
public class Quadrado extends Forma {
    private double lado;
    
    public Quadrado(Ponto2D[] pontos) {
        lado = pontos[0].calcularDistancia(pontos[1]);
    }

    @Override
    public double calcularArea(Ponto2D[] pontos) {
       return Math.pow(lado,2);
    }

    @Override
    public double Perimetro(Ponto2D[] pontos) {
        return lado * 4;
    }
}
