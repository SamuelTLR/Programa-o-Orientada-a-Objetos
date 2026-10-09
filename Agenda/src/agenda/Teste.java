/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agenda;
import java.util.Scanner;
/**
 *
 * @author aluno
 */
public class Teste {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nome = "", numero = "", endereco = "", email = "";
        Scanner input = new Scanner(System.in);
        SistemaAgenda tomazela = new SistemaAgenda();
        // TODO code application logic here
        int i = 1;
        while(i != 0) {
            System.out.println("Bem vindo a sua agenda virtual\nO que você deseja:\n(1)Incluir contato\n(2)Alterar Contato\n(3)Pesquisar\n(4)Lista");
            i = input.nextInt();
            input.nextLine();
            switch (i) {
                case 1:
                    System.out.println("Digite o nome: ");
                    nome = input.nextLine();
                    System.out.println("Digite o numero: ");
                    numero = input.nextLine();
                    System.out.println("Digite o endereço: ");
                    endereco = input.nextLine();
                    System.out.println("Digite o email: ");
                    email = input.nextLine();
                    Contato c1 = new Contato(nome, endereco, numero, email);
                    tomazela.incluir(c1);
                    break;
                case 2:
                    System.out.println("Digite o nome: ");
                    nome = input.nextLine();
                    tomazela.alterar(nome);
                break;
                case 3:
                    System.out.println("Digite o nome: ");
                    nome = input.nextLine();
                    tomazela.pesquisar(nome);
                break;
                case 4:
                    tomazela.listarContatos();
                break;
                default:
                    break;
            }
        }
    }
    
}
