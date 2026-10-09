/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agenda;
import java.util.Scanner;
import java.util.HashMap;
import servicos.ManipulaArquivoTexto;

/**
 *
 * @author aluno
 */
public class Agenda {
    Scanner input = new Scanner(System.in);
    private HashMap<String, Contato> agendaTelefones = new HashMap<>();

    public void incluir(Contato c1) {
        agendaTelefones.put(c1.getNome(), c1);
    }
    public void alterar(String nome) {
        Contato c;
        c = agendaTelefones.get(nome);
        if(c == null) {
            System.out.println("Contato não existente\n");
        }
        else {
            int i = 1;
            while(i != 0) {
            System.out.println("O que você deseja alterar:\n(1)Nome\n(2)Numero\n(3)Endereco\n(4)Email\n(0)Sair");
            i = input.nextInt();
            input.nextLine();
            switch (i) {
                case 1:
                    System.out.println("Digite para " + c.getNome() + " o seu novo nome:");
                    c.setNome(input.nextLine());
                    break;
                case 2:
                    System.out.println("Digite para " + c.getNome() + " com o número "+ c.getNumero() + " o seu novo numero:");
                    c.setNumero(input.nextLine());
                    break;
                case 3:
                    System.out.println("Digite para " + c.getNome() + " com o endereco "+ c.getEndereco() + " o seu novo endereço:");
                    c.setEndereco(input.nextLine());
                    break;
                case 4:
                    System.out.println("Digite para " + c.getNome() + " com o endereco "+ c.getEmail() + " o seu novo email:");
                    c.setEmail(input.nextLine());
                    break;
                case 0:
                    System.out.println("Atualizado!");
                    break;
                default:
                System.out.println("Numero inválido");
                    break;
            }
            }
        }
    }
    public void pesquisar(String nome) {
        Contato c;
        c = agendaTelefones.get(nome);
        if(c == null) {
            System.out.println("Contato não existente\n");
        }else {
            System.out.println("\n" +nome + " Agenda:\nNome: "+ c.getNome()+"\nNumero: " + c.getNumero() + "\nEndereco: " + c.getEndereco() + "\nEmail: " + c.getEmail());
        }
        

    }
    public void listarContatos() {
        System.out.println("Lista: ");
        for(Contato c: agendaTelefones.values()) {
            System.out.println("\nNome: "+ c.getNome()+"\nNumero: " + c.getNumero() + "\nEndereco: " + c.getEndereco() + "\nEmail: " + c.getEmail() + "\n");
        }
    }
    
    public void salvarAgenda(String arquivo) {
        ManipulaArquivoTexto mat = new ManipulaArquivoTexto();
        try {
            mat.abrirArquivoGravacao(arquivo);
            mat.gravarArquivoContato(agendaTelefones);
            mat.fecharArquivoGravacao(arquivo);
        }catch(Exception e) {
             System.err.print("Erro ao tentar ler o arquivo");               
        }
    }
    
    public void lerAgenda(String arquivo) {
        ManipulaArquivoTexto mat = new ManipulaArquivoTexto();
        try {
            mat.abrirArquivo(arquivo);
            agendaTelefones = mat.leituraArquivoContato();
            mat.fecharArquivo(arquivo);
        }catch(Exception e) {
            System.err.print("Erro ao tentar gravar o arquivo");
        }
        
    }
}
