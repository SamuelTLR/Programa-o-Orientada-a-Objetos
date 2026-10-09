/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;
import agenda.Contato;
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
    public void gravarArquivoContato(HashMap<String, Contato> agenda) {
        for(Contato c: agenda.values()) {
            gravador.format("%s;%s;%s;%s\n", c.getNome(), c.getEndereco(), c.getNumero(), c.getEmail());
        }
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
    public HashMap<String, Contato> leituraArquivoContato() {
        if(leitor == null) {
            System.err.print("Arquivo nulo, arquivo deve ser aberto antes\n");
            return null;
        } //Verificação de segurança
        
        HashMap<String, Contato> retorno = new HashMap<>();
        while(leitor.hasNext()) {
            String linha = leitor.nextLine();
            String[] campos = linha.split(";");
            Contato novo = new Contato(campos[0], campos[1], campos[2], campos[3]);
            retorno.put(campos[0], novo);
        }
        return retorno;
    }
    public String leituraArquivo() {
        String texto = null;
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
    public void fecharArquivo(String nome) {
        if(leitor != null) {
            leitor.close();
        }
    }
    
}
