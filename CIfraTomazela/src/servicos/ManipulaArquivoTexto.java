/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Formatter;
import java.util.HashMap;
/**
 *
 * @author aluno
 */
public class ManipulaArquivoTexto {
    private String arquivo;
    private Scanner leitor;
    private Formatter gravador;
    
    public ManipulaArquivoTexto() {
    }
    
    public void abrirArquivoGravacao(String arquivo) {
        try {
            gravador = new Formatter(new File(arquivo));
        } catch (FileNotFoundException ex) {
            System.err.print("Não foi possível criar o arquivo "+arquivo);
        }
    }
    
    public void gravaMensagemComChave (String message, int key) {
        gravador.format("%s\n%d", message, key);
        
    }
    
    public void fecharArquivoGravacao(String nome) {
        if(gravador != null) {
            gravador.close();
        }
    }
    
    public void abrirArquivo(String arquivo) {
        try {
            leitor = new Scanner(new File(arquivo));
        } catch (FileNotFoundException ex) {
            System.err.print("Não foi possível abrir o arquivo "+arquivo);
        }
    }
   
    public String leituraArquivo() {
        String texto = "";
        try {
            while(leitor.hasNext()) {
                String linha = leitor.nextLine();
                texto += linha + "\n";
            }
        }catch(Exception e) {
            System.err.print("Erro ao abrir o arquivo para leitura");
            return null;
        }
        return texto;
    }
    
    public int leituraArquivoAchaChave(String message) {
        String[] linhas;
        linhas = message.split("\n");
        String ultimaLinha = linhas[linhas.length - 1].trim();
        int numero = Integer.parseInt(ultimaLinha);
        return numero;
    }
    
    public String leituraArquivoAchaMensagem(String message) {
        String[] linhas;
        String mensagemSemNumero = "";
        linhas = message.split("\n");
        for(int i = 0; i < linhas.length - 1; i++){
            mensagemSemNumero += linhas[i];
        }
        return mensagemSemNumero;
    }
    
    public void fecharArquivo(String nome) {
        if(leitor != null) {
            leitor.close();
        }
    }
    
}