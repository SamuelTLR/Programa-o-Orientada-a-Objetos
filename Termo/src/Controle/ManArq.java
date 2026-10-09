
package Controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ManArq{
    private String arquivo;
    private Scanner leitor;
    private Formatter gravador;
    
    public ManArq(String arquivo){
        this.arquivo = arquivo;
    }
    
    public ManArq(){
        this.arquivo = "";
    }
    
    public void setArquivo(String arquivo){
        this.arquivo = arquivo;
    }
    
    public void abrirArquivoGravacao(){
        try {
            gravador = new Formatter(new File(arquivo));
        } catch (FileNotFoundException ex) {
            System.err.print("Ocorreu um erro na abertura do arquivo para gravacao: " + ex.getMessage());
        } 
    }
    
    public boolean gravarArquivo(String mensagem){
        if (gravador == null) {
            System.err.println("Gravador nao foi inicializado. Chame abrirArquivoGravacao() primeiro.");
            return false;
        }
        try {        
            gravador.format("%s\n", mensagem);
            return true; 
        } catch (Exception e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
            return false; 
        }
    }
    
    public void fecharArquivoGravacao() {
        if (gravador != null) {
            gravador.close();
            gravador = null;
        }
    }
    
    
    public void abrirArquivoLeitura() {
        try {
            leitor = new Scanner(new File(arquivo));
        } catch (FileNotFoundException ex) {
            System.err.print("Ocorreu erro ao abrir o arquivo para leitura. Arquivo nao encontrado: " + ex.getMessage());
        }
    }
    
   public ArrayList<String> lerArquivo() {
        ArrayList<String> dados = new ArrayList<>();
        if (leitor == null) {
            System.err.println("Leitor nao foi inicializado.");
            return dados;
        }
        try {
            while(leitor.hasNextLine()){
                dados.add(leitor.nextLine());
            }
        } catch (NoSuchElementException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado ao ler o arquivo: " + e.getMessage());
        }
        return dados;
    }

    public void fecharArquivoLeitura() {
        if (leitor != null) {
            leitor.close();
            leitor = null; 
        }
    }
}