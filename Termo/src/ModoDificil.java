
import Controle.Controlador;
import java.awt.Color;
import java.awt.SystemColor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author aluno
 */
public class ModoDificil extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ModoFacil.class.getName());
    
    
    private javax.swing.JButton[][] grade = new javax.swing.JButton[8][6];
    private char temp;
    private int coluna;
    private int linha;
    private boolean ganhou;
    private char[] palavra;
    private String stringPalavra;
    private char[] tentativa;
    private Controlador controlador;
    private static String arquivo;
    
    
    public void iniciar(){
        linha = 1;
        coluna = 1;
        ganhou = false;
        for(int i = 1; i < 8; i++){
            for(int j = 1; j < 6; j++){
                grade[i][j].setVisible(true);
                grade[i][j].setText("");
                grade[i][j].setOpaque(true);
                grade[i][j].setBackground(SystemColor.control);
            }   
        }
        btnGanhou.setVisible(false);
        btnGanhou.setOpaque(true);
        btnGanhou.setBorderPainted(false);
        btnGanhou.setBackground(SystemColor.control);
        mostrarNovaLinha(1);
        definirPalavra(controlador.selecionarPalvra());
    }
    
    public void definirPalavra(char[] novaPalavra){
        palavra = new char[8];
        stringPalavra = "";
        for(int i = 1; i < 8; i++){
            palavra[i] = novaPalavra[i-1];
            stringPalavra += palavra[i];
        }
    }

    public void mostrarNovaLinha(int linha){
        for(int i = 1; i < 6; i++){
            grade[linha][i].setVisible(true);
        }
    }
    
    public boolean verificarPalavra() {
        ganhou = true;
        char[] copia = new char[6];
        for (int p = 1; p < 8; p++) {
            copia[p] = palavra[p];
            System.out.println(copia[p]);
        }
        for (int i = 1; i < 8; i++) {
            if (copia[i] != tentativa[i]) {
                ganhou = false;
                grade[linha][i].setBackground(Color.GRAY);
            }
            if (copia[i] == tentativa[i]) {
                grade[linha][i].setBackground(Color.GREEN);
                copia[i] = '!';
                System.out.println("==");
                for (int k = 1; k < 8; k++) {
                    System.out.println(copia[k]);
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (copia[i] != tentativa[i]) {
                for (int j = 1; j < 8; j++) {
                    if (tentativa[i] == copia[j] && j != i) {
                        grade[linha][i].setBackground(Color.YELLOW);
                        copia[j] = '!';
                        System.out.println("Na palavra");
                        for (int k = 1; k < 8; k++) {
                            System.out.println(copia[k]);
                        }
                        break;
                    }
                }
            }
        }
        return ganhou;
    }
    
    public void pularLinha(){
        coluna = 1;
        linha++;
    }
    
    public void digitarLetra(char temp){
        if (ganhou) {
            return;
        }
        if(coluna == 1){
            tentativa = new char[8];
        }
        if(coluna == 7){
            
            grade[linha][coluna].setText(String.valueOf(temp));
            grade[linha][coluna].setFocusPainted(true);
            tentativa[coluna] = temp;
            
            if(verificarPalavra()){
                
                btnGanhou.setText("Você ganhou!");
                btnGanhou.setVisible(true);
                btnGanhou.setBackground(Color.GREEN);
                btnGanhou.setEnabled(false);
                pularLinha();
                
                return;
            } else if(linha == 5){
                
                btnGanhou.setText("Você perdeu a palavra era: " + stringPalavra);
                btnGanhou.setBackground(Color.RED);
                btnGanhou.setVisible(true);
                btnGanhou.setEnabled(false);
                pularLinha();
                
                return;
            }
            
            pularLinha();
            mostrarNovaLinha(linha);                          
        }
        else{
            grade[linha][coluna].setText(String.valueOf(temp));
                           tentativa[coluna] = temp;
            coluna++;
        }
    }
    
    /**
     * Creates new form Janela
     */
    public ModoDificil(String arquivo) {
        this.arquivo = arquivo;
        initComponents();
        this.controlador = new Controlador();
        controlador.setArquivo(arquivo);
        
        setLocationRelativeTo(null);

        try {
            for (int l = 1; l < 8; l++) {      
                for (int c = 1; c < 6; c++) {            
                    String nomeVariavel = "btnOP" + c + l; 
                    java.lang.reflect.Field field = this.getClass().getDeclaredField(nomeVariavel);
                    field.setAccessible(true);
                    grade[c][l] = (javax.swing.JButton) field.get(this);
                    grade[c][l].setText(""); 
                    grade[c][l].setOpaque(true);
                    grade[c][l].setBorderPainted(false);
                }
            }
        } catch (Exception e) {
        System.out.println("Erro ao mapear botoes: " + e.getMessage());
        e.printStackTrace();
        }
        iniciar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDificil = new javax.swing.JLabel();
        btnOP33 = new javax.swing.JButton();
        btnOP34 = new javax.swing.JButton();
        btnOP35 = new javax.swing.JButton();
        btnOP41 = new javax.swing.JButton();
        btnOP42 = new javax.swing.JButton();
        btnOP43 = new javax.swing.JButton();
        btnOP44 = new javax.swing.JButton();
        btnOP45 = new javax.swing.JButton();
        btnOP51 = new javax.swing.JButton();
        btnOP52 = new javax.swing.JButton();
        btnOP53 = new javax.swing.JButton();
        btnOP54 = new javax.swing.JButton();
        btnOP55 = new javax.swing.JButton();
        btnOP11 = new javax.swing.JButton();
        btnOP12 = new javax.swing.JButton();
        btnOP13 = new javax.swing.JButton();
        btnOP14 = new javax.swing.JButton();
        btnOP15 = new javax.swing.JButton();
        btnOP21 = new javax.swing.JButton();
        btnOP22 = new javax.swing.JButton();
        btnOP23 = new javax.swing.JButton();
        btnOP24 = new javax.swing.JButton();
        btnOP25 = new javax.swing.JButton();
        btnOP31 = new javax.swing.JButton();
        btnOP32 = new javax.swing.JButton();
        btnGanhou = new javax.swing.JButton();
        btnI = new javax.swing.JButton();
        btnF = new javax.swing.JButton();
        btnÇ = new javax.swing.JButton();
        btnE = new javax.swing.JButton();
        btnO = new javax.swing.JButton();
        btnG = new javax.swing.JButton();
        btnZ = new javax.swing.JButton();
        btnX = new javax.swing.JButton();
        btnH = new javax.swing.JButton();
        btnP = new javax.swing.JButton();
        btnQ = new javax.swing.JButton();
        btnU = new javax.swing.JButton();
        btnD = new javax.swing.JButton();
        btnL = new javax.swing.JButton();
        btnW = new javax.swing.JButton();
        btnR = new javax.swing.JButton();
        btnT = new javax.swing.JButton();
        btnA = new javax.swing.JButton();
        btnJ = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        btnY = new javax.swing.JButton();
        btnS = new javax.swing.JButton();
        btnK = new javax.swing.JButton();
        btnV = new javax.swing.JButton();
        btnB = new javax.swing.JButton();
        btnN = new javax.swing.JButton();
        btnM = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnOP36 = new javax.swing.JButton();
        btnOP37 = new javax.swing.JButton();
        btnOP46 = new javax.swing.JButton();
        btnOP47 = new javax.swing.JButton();
        btnOP56 = new javax.swing.JButton();
        btnOP57 = new javax.swing.JButton();
        btnOP16 = new javax.swing.JButton();
        btnOP17 = new javax.swing.JButton();
        btnOP26 = new javax.swing.JButton();
        btnOP27 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDificil.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDificil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDificil.setText("Modo Dificil");

        btnOP33.setText("jButton3");
        btnOP33.setAlignmentY(0.0F);
        btnOP33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP33.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP33.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP33.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP34.setText("jButton4");
        btnOP34.setAlignmentY(0.0F);
        btnOP34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP34.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP34.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP34.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP35.setText("jButton5");
        btnOP35.setAlignmentY(0.0F);
        btnOP35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP35.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP35.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP35.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP41.setText("jButton1");
        btnOP41.setAlignmentY(0.0F);
        btnOP41.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP41.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP41.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP41.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP42.setText("jButton2");
        btnOP42.setAlignmentY(0.0F);
        btnOP42.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP42.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP42.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP42.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP43.setText("jButton3");
        btnOP43.setAlignmentY(0.0F);
        btnOP43.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP43.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP43.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP43.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP44.setText("jButton4");
        btnOP44.setAlignmentY(0.0F);
        btnOP44.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP44.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP44.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP44.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP45.setText("jButton5");
        btnOP45.setAlignmentY(0.0F);
        btnOP45.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP45.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP45.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP45.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP51.setText("jButton1");
        btnOP51.setAlignmentY(0.0F);
        btnOP51.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP51.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP51.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP51.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP52.setText("jButton2");
        btnOP52.setAlignmentY(0.0F);
        btnOP52.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP52.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP52.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP52.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP53.setText("jButton3");
        btnOP53.setAlignmentY(0.0F);
        btnOP53.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP53.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP53.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP53.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP54.setText("jButton4");
        btnOP54.setAlignmentY(0.0F);
        btnOP54.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP54.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP54.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP54.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP55.setText("jButton5");
        btnOP55.setAlignmentY(0.0F);
        btnOP55.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP55.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP55.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP55.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP11.setText("jButton1");
        btnOP11.setAlignmentY(0.0F);
        btnOP11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP11.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP11.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP11.setPreferredSize(new java.awt.Dimension(75, 40));
        btnOP11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOP11ActionPerformed(evt);
            }
        });

        btnOP12.setText("jButton2");
        btnOP12.setAlignmentY(0.0F);
        btnOP12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP12.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP12.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP12.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP13.setText("jButton3");
        btnOP13.setAlignmentY(0.0F);
        btnOP13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP13.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP13.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP13.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP14.setText("jButton4");
        btnOP14.setAlignmentY(0.0F);
        btnOP14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP14.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP14.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP14.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP15.setText("jButton5");
        btnOP15.setAlignmentY(0.0F);
        btnOP15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP15.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP15.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP15.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP21.setText("jButton1");
        btnOP21.setAlignmentY(0.0F);
        btnOP21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP21.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP21.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP21.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP22.setText("jButton2");
        btnOP22.setAlignmentY(0.0F);
        btnOP22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP22.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP22.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP22.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP23.setText("jButton3");
        btnOP23.setAlignmentY(0.0F);
        btnOP23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP23.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP23.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP23.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP24.setText("jButton4");
        btnOP24.setAlignmentY(0.0F);
        btnOP24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP24.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP24.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP24.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP25.setText("jButton5");
        btnOP25.setAlignmentY(0.0F);
        btnOP25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP25.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP25.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP25.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP31.setText("jButton1");
        btnOP31.setAlignmentY(0.0F);
        btnOP31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP31.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP31.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP31.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP32.setText("jButton2");
        btnOP32.setAlignmentY(0.0F);
        btnOP32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP32.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP32.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP32.setPreferredSize(new java.awt.Dimension(75, 40));

        btnGanhou.setText("jButton1");
        btnGanhou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGanhouActionPerformed(evt);
            }
        });

        btnI.setText("I");
        btnI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIActionPerformed(evt);
            }
        });

        btnF.setText("F");
        btnF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFActionPerformed(evt);
            }
        });

        btnÇ.setText("Ç");
        btnÇ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnÇActionPerformed(evt);
            }
        });

        btnE.setText("E");
        btnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEActionPerformed(evt);
            }
        });

        btnO.setText("O");
        btnO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOActionPerformed(evt);
            }
        });

        btnG.setText("G");
        btnG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGActionPerformed(evt);
            }
        });

        btnZ.setText("Z");
        btnZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZActionPerformed(evt);
            }
        });

        btnX.setText("X");
        btnX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXActionPerformed(evt);
            }
        });

        btnH.setText("H");
        btnH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHActionPerformed(evt);
            }
        });

        btnP.setText("P");
        btnP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPActionPerformed(evt);
            }
        });

        btnQ.setText("Q");
        btnQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQActionPerformed(evt);
            }
        });

        btnU.setText("U");
        btnU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUActionPerformed(evt);
            }
        });

        btnD.setText("D");
        btnD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDActionPerformed(evt);
            }
        });

        btnL.setText("L");
        btnL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLActionPerformed(evt);
            }
        });

        btnW.setText("W");
        btnW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWActionPerformed(evt);
            }
        });

        btnR.setText("R");
        btnR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRActionPerformed(evt);
            }
        });

        btnT.setText("T");
        btnT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTActionPerformed(evt);
            }
        });

        btnA.setText("A");
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });

        btnJ.setText("J");
        btnJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJActionPerformed(evt);
            }
        });

        btnC.setText("C");
        btnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCActionPerformed(evt);
            }
        });

        btnY.setText("Y");
        btnY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYActionPerformed(evt);
            }
        });

        btnS.setText("S");
        btnS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSActionPerformed(evt);
            }
        });

        btnK.setText("K");
        btnK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKActionPerformed(evt);
            }
        });

        btnV.setText("V");
        btnV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVActionPerformed(evt);
            }
        });

        btnB.setText("B");
        btnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBActionPerformed(evt);
            }
        });

        btnN.setText("N");
        btnN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNActionPerformed(evt);
            }
        });

        btnM.setText("M");
        btnM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMActionPerformed(evt);
            }
        });

        btnSair.setText("Menu");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnOP36.setText("jButton4");
        btnOP36.setAlignmentY(0.0F);
        btnOP36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP36.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP36.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP36.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP37.setText("jButton5");
        btnOP37.setAlignmentY(0.0F);
        btnOP37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP37.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP37.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP37.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP46.setText("jButton4");
        btnOP46.setAlignmentY(0.0F);
        btnOP46.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP46.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP46.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP46.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP47.setText("jButton5");
        btnOP47.setAlignmentY(0.0F);
        btnOP47.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP47.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP47.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP47.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP56.setText("jButton4");
        btnOP56.setAlignmentY(0.0F);
        btnOP56.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP56.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP56.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP56.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP57.setText("jButton5");
        btnOP57.setAlignmentY(0.0F);
        btnOP57.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP57.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP57.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP57.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP16.setText("jButton4");
        btnOP16.setAlignmentY(0.0F);
        btnOP16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP16.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP16.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP16.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP17.setText("jButton5");
        btnOP17.setAlignmentY(0.0F);
        btnOP17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP17.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP17.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP17.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP26.setText("jButton4");
        btnOP26.setAlignmentY(0.0F);
        btnOP26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP26.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP26.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP26.setPreferredSize(new java.awt.Dimension(75, 40));

        btnOP27.setText("jButton5");
        btnOP27.setAlignmentY(0.0F);
        btnOP27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOP27.setMaximumSize(new java.awt.Dimension(75, 40));
        btnOP27.setMinimumSize(new java.awt.Dimension(75, 40));
        btnOP27.setPreferredSize(new java.awt.Dimension(75, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(btnGanhou, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDificil, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOP31, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP32, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP33, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP34, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP35, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOP41, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP42, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP43, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP44, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP45, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOP51, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP52, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP53, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP54, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP55, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOP11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOP21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP25, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOP36, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP37, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOP46, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP47, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOP56, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP57, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOP16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOP26, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOP27, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(117, 117, 117))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnQ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnW, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnR, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnY, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnI, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnO, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnG, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnÇ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnZ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnM, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(170, 170, 170))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblDificil)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOP11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOP21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOP31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOP41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP45, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOP51, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP52, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP53, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP54, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP55, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOP16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOP26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOP36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOP46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP47, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOP56, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOP57, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addComponent(btnGanhou, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnW, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnR, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnY, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnÇ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnX, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOP11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOP11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOP11ActionPerformed

    private void btnGanhouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGanhouActionPerformed

    }//GEN-LAST:event_btnGanhouActionPerformed

    private void btnIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIActionPerformed
        digitarLetra('I');
    }//GEN-LAST:event_btnIActionPerformed

    private void btnFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFActionPerformed
        digitarLetra('F');
    }//GEN-LAST:event_btnFActionPerformed

    private void btnÇActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnÇActionPerformed
        digitarLetra('Ç');
    }//GEN-LAST:event_btnÇActionPerformed

    private void btnEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEActionPerformed
        digitarLetra('E');
    }//GEN-LAST:event_btnEActionPerformed

    private void btnOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOActionPerformed
        digitarLetra('O');
    }//GEN-LAST:event_btnOActionPerformed

    private void btnGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGActionPerformed
        digitarLetra('G');
    }//GEN-LAST:event_btnGActionPerformed

    private void btnZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZActionPerformed
        digitarLetra('Z');
    }//GEN-LAST:event_btnZActionPerformed

    private void btnXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXActionPerformed
        digitarLetra('X');
    }//GEN-LAST:event_btnXActionPerformed

    private void btnHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHActionPerformed
        digitarLetra('H');
    }//GEN-LAST:event_btnHActionPerformed

    private void btnPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPActionPerformed
        digitarLetra('P');
    }//GEN-LAST:event_btnPActionPerformed

    private void btnQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQActionPerformed
        digitarLetra('Q');
    }//GEN-LAST:event_btnQActionPerformed

    private void btnUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUActionPerformed
        digitarLetra('U');
    }//GEN-LAST:event_btnUActionPerformed

    private void btnDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDActionPerformed
        digitarLetra('D');
    }//GEN-LAST:event_btnDActionPerformed

    private void btnLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLActionPerformed
        digitarLetra('L');
    }//GEN-LAST:event_btnLActionPerformed

    private void btnWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWActionPerformed
        digitarLetra('W');
    }//GEN-LAST:event_btnWActionPerformed

    private void btnRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRActionPerformed
        digitarLetra('R');
    }//GEN-LAST:event_btnRActionPerformed

    private void btnTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTActionPerformed
        digitarLetra('T');
    }//GEN-LAST:event_btnTActionPerformed

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
        digitarLetra('A');
    }//GEN-LAST:event_btnAActionPerformed

    private void btnJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJActionPerformed
        digitarLetra('J');
    }//GEN-LAST:event_btnJActionPerformed

    private void btnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCActionPerformed
        digitarLetra('C');
    }//GEN-LAST:event_btnCActionPerformed

    private void btnYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYActionPerformed
        digitarLetra('Y');
    }//GEN-LAST:event_btnYActionPerformed

    private void btnSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSActionPerformed
        digitarLetra('S');
    }//GEN-LAST:event_btnSActionPerformed

    private void btnKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKActionPerformed
        digitarLetra('K');
    }//GEN-LAST:event_btnKActionPerformed

    private void btnVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVActionPerformed
        digitarLetra('V');
    }//GEN-LAST:event_btnVActionPerformed

    private void btnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBActionPerformed
        digitarLetra('B');
    }//GEN-LAST:event_btnBActionPerformed

    private void btnNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNActionPerformed
        digitarLetra('N');
    }//GEN-LAST:event_btnNActionPerformed

    private void btnMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMActionPerformed
        digitarLetra('M');
    }//GEN-LAST:event_btnMActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        iniciar();
    }//GEN-LAST:event_btnNovoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnB;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnD;
    private javax.swing.JButton btnE;
    private javax.swing.JButton btnF;
    private javax.swing.JButton btnG;
    private javax.swing.JButton btnGanhou;
    private javax.swing.JButton btnH;
    private javax.swing.JButton btnI;
    private javax.swing.JButton btnJ;
    private javax.swing.JButton btnK;
    private javax.swing.JButton btnL;
    private javax.swing.JButton btnM;
    private javax.swing.JButton btnN;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnO;
    private javax.swing.JButton btnOP11;
    private javax.swing.JButton btnOP12;
    private javax.swing.JButton btnOP13;
    private javax.swing.JButton btnOP14;
    private javax.swing.JButton btnOP15;
    private javax.swing.JButton btnOP16;
    private javax.swing.JButton btnOP17;
    private javax.swing.JButton btnOP21;
    private javax.swing.JButton btnOP22;
    private javax.swing.JButton btnOP23;
    private javax.swing.JButton btnOP24;
    private javax.swing.JButton btnOP25;
    private javax.swing.JButton btnOP26;
    private javax.swing.JButton btnOP27;
    private javax.swing.JButton btnOP31;
    private javax.swing.JButton btnOP32;
    private javax.swing.JButton btnOP33;
    private javax.swing.JButton btnOP34;
    private javax.swing.JButton btnOP35;
    private javax.swing.JButton btnOP36;
    private javax.swing.JButton btnOP37;
    private javax.swing.JButton btnOP41;
    private javax.swing.JButton btnOP42;
    private javax.swing.JButton btnOP43;
    private javax.swing.JButton btnOP44;
    private javax.swing.JButton btnOP45;
    private javax.swing.JButton btnOP46;
    private javax.swing.JButton btnOP47;
    private javax.swing.JButton btnOP51;
    private javax.swing.JButton btnOP52;
    private javax.swing.JButton btnOP53;
    private javax.swing.JButton btnOP54;
    private javax.swing.JButton btnOP55;
    private javax.swing.JButton btnOP56;
    private javax.swing.JButton btnOP57;
    private javax.swing.JButton btnP;
    private javax.swing.JButton btnQ;
    private javax.swing.JButton btnR;
    private javax.swing.JButton btnS;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnT;
    private javax.swing.JButton btnU;
    private javax.swing.JButton btnV;
    private javax.swing.JButton btnW;
    private javax.swing.JButton btnX;
    private javax.swing.JButton btnY;
    private javax.swing.JButton btnZ;
    private javax.swing.JButton btnÇ;
    private javax.swing.JLabel lblDificil;
    // End of variables declaration//GEN-END:variables
}
