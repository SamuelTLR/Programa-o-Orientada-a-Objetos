package principal_Samuel_Tomazela;
import java.util.ArrayList;

public class Morador {
    private String nome;
    private String telefone;
    private int num_apartamento;
    private ArrayList<Reserva> reservas;
    
    public Morador() {
        nome = "";
        telefone = "";
        this.num_apartamento = 0;
        reservas = new ArrayList<>();
    }
    public Morador(String nome, String telefone, int num_apartamento) {
        this.nome = nome;
        this.telefone = telefone;
        this.num_apartamento = num_apartamento;
        reservas = new ArrayList<>();
    }
    public Morador(String nome, String telefone, int num_apartamento, ArrayList<Reserva> reservas) {
        this.nome = nome;
        this.telefone = telefone;
        this.num_apartamento = num_apartamento;
        this.reservas = reservas;
    }

    public boolean addReserva(Reserva r1, Sistema s1) {
        boolean x;
        x = s1.addReserva(r1);
        if(x) {
            return reservas.add(r1);
        }else {
            return x;
        }
        
    }
    public boolean removeReserva(Reserva r1, Sistema s1) {
        s1.removeReserva(r1);
        return reservas.remove(r1);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public int getNum_apartamento() {
        return num_apartamento;
    }
    public void setNum_apartamento(int num_apartamento) {
        this.num_apartamento = num_apartamento;
    }
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    } 

    

}
