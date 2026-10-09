
package visao;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Calculadora;

public class Janela extends JFrame implements ActionListener{
    
    private JPanel teclado;
    private JTextField visor;
    
    private JButton[] botoes;
    
    private String[] face = {"C","7","8","9","/",
                             "CE","4","5","6","*",
                             "X²","1","2","3","-",
                             "%",".","0","=","+",};
    private Calculadora calc;
    
    public Janela(){
        setTitle("Calculadora");
        instanciarComponentes();
        definirLayout();
        adicionarComponentes();
        registrarHandlerDeEventos();
    }
    
    private void instanciarComponentes(){
        calc = new Calculadora();
        teclado = new JPanel();
        visor = new JTextField();
        botoes = new JButton[20];
        for(int i=0;i<botoes.length;i++){
            botoes[i]=new JButton(face[i]);
        }
    }
    
    private void definirLayout(){
        setLayout(new BorderLayout());
        teclado.setLayout(new GridLayout(4,5));
    }
    
    private void adicionarComponentes(){
        add(visor,BorderLayout.NORTH);
        for(int i=0;i<botoes.length;i++){
            teclado.add(botoes[i]);
        }
        add(teclado,BorderLayout.SOUTH);
    }
    
    private void registrarHandlerDeEventos(){
        for(int i=0;i<botoes.length;i++){
            botoes[i].addActionListener(this);
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String faceB =((JButton)e.getSource()).getText();
        try{
            Double.valueOf(faceB);
            calc.concatenarValor(faceB);           
        }catch (NumberFormatException ex){
            if (faceB.equals(".")) {
                calc.concatenarValor(faceB);
            } else {
                calc.decidirAcao(faceB);
            }
        }finally{
            visor.setText(calc.getVisor());
        }
    }
    
    
    
}
