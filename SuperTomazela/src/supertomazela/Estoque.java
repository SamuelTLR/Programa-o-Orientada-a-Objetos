/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertomazela;
import java.util.ArrayList;
/**
 *
 * @author aluno
 */
public class Estoque {
    private ArrayList<ItemProduto> estante = new ArrayList<>();

    public boolean addItemProduto(ItemProduto item) {
        return estante.add(item);
    }
    public ItemProduto consultarItemProduto(int codigo) {
        for(int i = 0; i < estante.size(); i++) {
            if(estante.get(i).getProduto().getCodigo() == codigo) {
                return estante.get(i);
            }
        }
        return null;
    }
    public int consultarItemProduro(String nome){
        for(int i = 0; i < estante.size(); i++) {
            if(estante.get(i).getProduto().getDescricao() == nome) {
                return estante.get(i).getProduto().getCodigo();
            }
        }
        return 0;
    }
    public String ListarProdutos(){
        String Lista = "";
        for(int i = 0; i < estante.size(); i++) {
            Lista += "Descrição: ";
            Lista += estante.get(i).getProduto().getDescricao();
            Lista += "\nQuantidade: ";
            Lista += estante.get(i).getQuantidade();
            Lista += "\nValor: ";
            Lista += estante.get(i).getValor();
            Lista += "\nCódigo: ";
            Lista += estante.get(i).getProduto().getCodigo();
            Lista +='\n';
            
        }
        return Lista;
    }
    
    public boolean retirarItemdoEstoque(int codigo, int quantidade) {
        for(int i =0; i < estante.size(); i++) {
            if(estante.get(i).getProduto().getCodigo() == codigo) {
                estante.get(i).setQuantidade(estante.get(i).getQuantidade() - quantidade);
                return true;
            }
        }
        return false;
    }
    
}
