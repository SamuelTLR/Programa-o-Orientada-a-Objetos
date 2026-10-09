/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forma;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Circulo extends Forma {
    private double raio;
    public Circulo(Ponto2D[] pontos) {
        raio = pontos[0].calcularDistancia(pontos[1]) / 2;
    }
    @Override
    public double calcularArea(Ponto2D[] pontos) {
        System.out.println("Raio = " + raio);
        System.out.println("Área do círculo = " + (Math.PI * Math.pow(raio, 2)));
        return Math.PI * Math.pow(raio, 2);
    }

    @Override
    public double Perimetro(Ponto2D[] pontos) {
        double resul = 0;
        resul = 2 * Math.PI * raio;
       return resul;
    }
    
}
