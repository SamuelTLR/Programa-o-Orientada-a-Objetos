package principal_Samuel_Tomazela;

import java.util.ArrayList;

public class Administrador {
    private String nome;
    private int codigo;
    private ArrayList<Morador> moradores;
    public Administrador() {
        nome = "";
        codigo = 0;
        moradores = new ArrayList<>();
    }
    public Administrador(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
        moradores = new ArrayList<>();
    }
    public void Autorizar(Reserva r1, Sistema s1) {
        ArrayList<Reserva> reservas = new ArrayList<>();
        reservas = s1.getReservas();
        for(Reserva r: reservas) {
            if(r1 == r) {
                r.setAutorizacao(true);
                r.setStatus("Autorizada");
            }
        }
        for(Reserva r: reservas) {
            if(r.isAutorizacao() != true)
            if(r1.getData().equals(r.getData())) {
                    if(r1.getHorario_inicio() == r.getHorario_inicio()) {
                        r.setAutorizacao(false);
                        r.setStatus("Negada");
                    }else {
                        int h1, h2, d1;
                        h1 = r1.getHorario_inicio();
                        h2 = r.getHorario_inicio();
                        d1 = r1.getDuracao();
                        if(h1 + d1 > h2) {
                            r.setAutorizacao(false);
                            r.setStatus("Negada");
                        }
                    }
                    
                }
        }

    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}
