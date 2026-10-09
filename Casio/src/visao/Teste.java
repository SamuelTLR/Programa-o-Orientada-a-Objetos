
package visao;

import javax.swing.JFrame;


public class Teste {
    public static void main(String[] args) {
        Janela janela = new Janela();
        janela.setSize(300,180);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
