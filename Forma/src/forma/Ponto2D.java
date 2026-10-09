/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forma;

/**
 *
 * @author aluno
 */
public class Ponto2D {
    private double x;
    private double y;
    
    public Ponto2D() {
        x = 0.0;
        y = 0.0;
    }
    public Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Ponto2D(Ponto2D ponto) {
        this.x = ponto.getX();
        this.y = ponto.getY();
    }
    public double calcularDistancia(Ponto2D ponto) {
        double x2 = 0, y2 = 0, resul = 0;
        x2 = x - ponto.getX();
        y2= y - ponto.getY();
        resul = Math.sqrt(Math.pow(x2,2) + Math.pow(y2, 2));
        return resul;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
}
