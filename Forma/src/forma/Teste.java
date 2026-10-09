/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forma;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Teste {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Espaco2D espaco = new Espaco2D();
        int i = 1, cont = 0;
        double x = 0, y = 0;
        while(i != 0) {
            System.out.println("Bem vindo ao sistema de formas geometricas:\n(1) Adicionar Forma\n(2) Calcular Area Total\n(3) Calcular Perimetro Total\n(4) Mostrar Tipo\n(0) Sair");
            i = in.nextInt();
            switch (i) {
                case 1:
                    // Adicionar Forma
                    System.out.println("Adicionando Forma\n(1) Circulo\n(2) Triangulo\n(3) Quadrado\n(0) Voltar");
                    int tipoForma = in.nextInt();
                    switch (tipoForma) {
                        case 1:
                        // Adicionar círculo
                            System.out.println("Digite a coordenada X do centro do círculo:");
                            x = in.nextDouble();
                            in.nextLine(); // Consumir a quebra de linha
                            System.out.println("Digite a coordenada Y do centro do círculo:");
                            y = in.nextDouble();
                            in.nextLine(); // Consumir a quebra de linha
                            System.out.println("Digite o raio do círculo:");
                            double raio = in.nextDouble();
                            in.nextLine(); // Consumir a quebra de linha
                            Ponto2D p1 = new Ponto2D(x - raio, y);
                            Ponto2D p2 = new Ponto2D(x + raio, y);
                            Forma circulo = Forma.geraForma(new Ponto2D[]{p1, p2});
                            if(circulo != null) {
                                System.out.println("Círculo adicionado com sucesso!");
                                espaco.adicionarForma(circulo);
                            } else {
                                System.out.println("Erro ao adicionar círculo.");
                            }
                            break;
                        case 2:
                            // Adicionar triângulo
                            System.out.println("Digite as coordenadas dos 3 pontos do triângulo:");
                            Ponto2D[] triangulo = new Ponto2D[3];
                            triangulo[0] = new Ponto2D();
                            triangulo[1] = new Ponto2D();
                            triangulo[2] = new Ponto2D();
                            for(int h = 0; h < 3; h++) {
                                System.out.println("Digite a coordenada X: ");
                                x = in.nextDouble();
                                in.nextLine(); // Consumir a quebra de linha
                                triangulo[h].setX(x);
                                System.out.println("Digite a coordenada Y: ");
                                y = in.nextDouble();
                                in.nextLine(); // Consumir a quebra de linha
                                triangulo[h].setY(y);
                            }
                            Forma tForma = Forma.geraForma(triangulo);
                            if(tForma != null) {
                                System.out.println("Triangulo criado!");
                                espaco.adicionarForma(tForma);
                            }else {
                                System.out.println("Falha na criação do triângulo");
                            }
                break;
                        case 3:
                            // Adicionar quadrado
                            System.out.println("Digite as coordenadas dos 4 pontos do quadrado: ");
                            Ponto2D[] quadrado = new Ponto2D[4];
                            quadrado[0] = new Ponto2D();    
                            quadrado[1] = new Ponto2D();
                            quadrado[2] = new Ponto2D();
                            quadrado[3] = new Ponto2D();
                            for(int h = 0; h < 4; h++) {
                                System.out.println("Digite a coordenada X: ");
                                x = in.nextDouble(); 
                                in.nextLine(); // Consumir a quebra de linha
                                quadrado[h].setX(x);
                                System.out.println("Digite a coordenada Y: ");
                                y = in.nextDouble();
                                in.nextLine(); // Consumir a quebra de linha
                                quadrado[h].setY(y);
                            }
                            Forma qForma = Forma.geraForma(quadrado);
                            if(qForma != null) {
                                System.out.println("Quadrado criado!");
                                espaco.adicionarForma(qForma);
                            }else {
                                System.out.println("Falha na criação do quadrado");
                            }
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;
                case 2:
                    // Calcular Area Total
                    System.out.println("Área Total = " + espaco.calcularAreaTotal());

                    break;
                case 3:
                    // Calcular Perimetro Total
                    System.out.println("Perímetro Total = " + espaco.calcularPerimetroTotal());
                    break;
                case 4:
                    // Calcular Mostrar Tipo
                     System.out.println("Triângulos do tipo: \n" + espaco.mostrarTipoTriangulo());
                    break;
                default:
                    break;
            }
}}}
