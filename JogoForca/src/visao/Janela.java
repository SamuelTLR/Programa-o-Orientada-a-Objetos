package visao;

import modelo.Forca;
import servicos.ManipulaArquivoTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Janela extends JFrame implements ActionListener {

    private JPanel teclado;
    private JTextField visor;
    private JLabel labelTentativas;
    private JButton[] botoes;

    private String[] face = {"A","B","C","D","E"
                            ,"F","G","H","I","J"
                            ,"K","L","M","N","O"
                            ,"P","Q","R","S","T"
                            ,"U","V","W","X","Y"
                            ,"Z"};

    private Forca forca;

    public Janela() {
        setTitle("Forca");
        instanciarComponentes();
        definirLayout();
        adicionarComponentes();
        registrarHandlerDeEventos();
        iniciarJogo();
    }

    private void instanciarComponentes() {
        forca = new Forca();
        teclado = new JPanel();
        visor = new JTextField();
        visor.setEditable(false);
        visor.setHorizontalAlignment(JTextField.CENTER);
        visor.setFont(new Font("Arial", Font.BOLD,20));

        labelTentativas = new JLabel("Tentativas: 15");
        labelTentativas.setHorizontalAlignment(JLabel.CENTER);

        botoes = new JButton[26];
        for(int i=0;i<botoes.length; i++) {
            botoes[i] = new JButton(face[i]);
        }
    }

    private void definirLayout() {
        setLayout(new BorderLayout(10, 10));
        teclado.setLayout(new GridLayout(5, 6, 5, 5));
    }

    private void adicionarComponentes() {
        JPanel painelSuperior = new JPanel(new BorderLayout());
        painelSuperior.add(visor, BorderLayout.CENTER);
        painelSuperior.add(labelTentativas, BorderLayout.SOUTH);

        add(painelSuperior, BorderLayout.NORTH);

        for (int i = 0; i < botoes.length; i++) {
            teclado.add(botoes[i]);
        }
        add(teclado, BorderLayout.CENTER);
    }

    private void registrarHandlerDeEventos() {
        for(int i=0;i<botoes.length;i++) {
            botoes[i].addActionListener(this);
        }
    }

    private void iniciarJogo() {
        String palavraSelecionada, palavraAuxiliar;
        ManipulaArquivoTexto manipulaArquivoTexto = new ManipulaArquivoTexto();

        manipulaArquivoTexto.abrirArquivo("palavras.txt");
        palavraAuxiliar = manipulaArquivoTexto.leituraArquivo();

        Set<String> palavras = new HashSet<>(Arrays.asList(palavraAuxiliar.split(" ")));

        ArrayList<String> listaPalavras = new ArrayList<>(palavras);

        Random random = new Random();
        int indice = random.nextInt(listaPalavras.size());

        palavraSelecionada = listaPalavras.get(indice);
        forca.setPalavra(palavraSelecionada);
        System.out.println(palavraSelecionada);
        atualizarVisor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botaoClicado = (JButton) e.getSource();
        char letra = botaoClicado.getText().charAt(0);

        botaoClicado.setEnabled(false);

        forca.letraSelecionada(letra);

        atualizarVisor();
        verificarFimDeJogo();
    }

    private void atualizarVisor() {
        visor.setText(forca.getPalavraRevelada());
        labelTentativas.setText("Tentativas: " + forca.getTentativasRestantes());
    }

    private void verificarFimDeJogo() {
        if(forca.ganhou()) {
            JOptionPane.showMessageDialog(this, "Parabéns! Você ganhou!");
            reniciarJogo();
        } else if (forca.perdeu()) {
        JOptionPane.showMessageDialog(this, "Você perdeu! Tente novamente.");
        reniciarJogo();
        }
    }

    private void reniciarJogo() {
        forca.reiniciar();
        for(JButton botao : botoes) {
            botao.setEnabled(true);
        }
        iniciarJogo();
    }
}
