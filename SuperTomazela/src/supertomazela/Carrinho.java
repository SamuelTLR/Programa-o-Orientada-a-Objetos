/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertomazela;

/**
 *
 * @author aluno
 */
public class Carrinho {
    private ItemProduto[] carrinho = new ItemProduto[10];
    private double valorTotal;
    
    public boolean addItemProduto(ItemProduto item) {
        for(int i = 0; i < carrinho.length; i++) {
            if(carrinho[i] == null) {
                carrinho[i] = item;
                return true;
            }
        }
        return false;
    }
    public boolean removeItemProduto(int codProduto) {
        for(int i = 0; i < carrinho.length; i++) {
            if(carrinho[i].getProduto().getCodigo() == codProduto) {
                carrinho[i] = null;
                return true;
            }
        }
        return false;
    }
        
    public double getvalorTotal() {
        double total = 0.0;
        for(int i = 0; i < carrinho.length ; i++) {
            if(carrinho[i] != null) {
                total += carrinho[i].getProduto().getValor();
            }
        }
        return total;
    }
}
