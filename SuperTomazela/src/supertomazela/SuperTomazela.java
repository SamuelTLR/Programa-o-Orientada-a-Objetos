/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package supertomazela;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author aluno
 */
public class SuperTomazela {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Estoque Tomazela = new Estoque();
        int x = 0, y = 0, cod = 0, quantidade = 0;
        double valor = 0, aux = 0;
        String nome, lista = " ";
        while(x == 0) {
            System.out.println("\n----Bem vindo ao SuperTomazela----");
            System.out.println("1 - Criar Produto\n2 - Lista de Produtos no Estoque\n3 - Consultar Produto\n4 - Comprar\n5 - Sair");
            y = input.nextInt();
            switch(y) {
                case 1:
                    System.out.println("Digite o nome do produto: ");
                    nome = input.next();
                    System.out.println("Digite o valor do produto:");
                    valor = input.nextDouble();
                    Produto p1 = new Produto(nome, cod, valor);
                    System.out.println("Quanto você quer colocar no estoque: ");
                    quantidade = input.nextInt();
                    ItemProduto Ip1 = new ItemProduto(p1, quantidade, valor);
                    Tomazela.addItemProduto(Ip1);
                    cod++;
                break;
                case 2:
                   if(Tomazela != null){
                       lista = Tomazela.ListarProdutos();
                       System.out.println(lista);
                   }
                break;
                case 3:
                    System.out.println("\nQual produto você gostaria de consultar: ");
                    lista = Tomazela.ListarProdutos();
                    System.out.println(lista);
                    System.out.println("Digite o código:");
                    cod = input.nextInt();
                    ItemProduto p2 = new ItemProduto();
                    p2 = Tomazela.consultarItemProduto(cod);
                    System.out.println("\nDecrição: ");
                    System.out.println(p2.getProduto().getDescricao());
                    System.out.println("Quantidade: ");
                    System.out.println(p2.getQuantidade());
                    System.out.println("Valor: ");
                    System.out.println(p2.getValor());
                break;
                case 4:
                    nome = "";
                    System.out.println("O que você deseja(Descrição):");
                    nome = input.next();
                    ItemProduto p3 = new ItemProduto();
                    p3 = Tomazela.consultarItemProduto(Tomazela.consultarItemProduro(nome));
                    System.out.println("\nDecrição: ");
                    System.out.println(p3.getProduto().getDescricao());
                    System.out.println("Quantidade: ");
                    System.out.println(p3.getQuantidade());
                    System.out.println("Valor: ");
                    System.out.println(p3.getValor());
                    System.out.println("Quantos  você quer?");
                    quantidade = input.nextInt();
                    
                break;
                case 5: 
                    System.out.println("\n-----Tchau-----");
                    x = 1;
                break;
            }
        }
    }
    
}
