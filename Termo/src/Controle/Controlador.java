/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import java.util.ArrayList;
import java.util.Random;

public class Controlador {
    private ArrayList<String> dados;
    private ManArq manArq;
    
    public Controlador(){
        this.dados = new ArrayList<>();
        this.manArq = new ManArq();
    }
    
    public void setArquivo(String arquivo){
        manArq.setArquivo(arquivo);
    }
    
    //retorna uma palavra 
    public char[] selecionarPalvra(){
        manArq.abrirArquivoLeitura();
        dados = manArq.lerArquivo();
        Random random = new Random();
        int indice = random.nextInt(200);
        String aux = dados.get(indice);
        aux = aux.toUpperCase();
        char[] vetorChar = aux.toCharArray();
        return vetorChar;
    }
    
    
}
