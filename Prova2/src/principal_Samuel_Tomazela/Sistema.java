package principal_Samuel_Tomazela;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<Reserva> reservas;

    public Sistema() {
        reservas = new ArrayList<>();
    }

    public boolean addReserva(Reserva r1) {
        if(reservas != null) {
            for(int i = 0; i < reservas.size(); i++) {
                if(reservas.get(i).isAutorizacao())
                if(r1.getData().equals(reservas.get(i).getData())) {
                    if(r1.getHorario_inicio() == reservas.get(i).getHorario_inicio()) {
                        return false;
                    }else {
                        int h1, h2, d1;
                        h1 = r1.getHorario_inicio();
                        h2 = reservas.get(i).getHorario_inicio();
                        d1 = r1.getDuracao();
                        if(h1 + d1 > h2) {
                            return false;
                        }
                    }
                    
                }
            }
        }
        
        return reservas.add(r1);
    }
    @Override
    public String toString() {
        String resposta = ""; 
        for(Reserva r: reservas) {
            resposta += "\n\nReserva:\nData: "+ r.getData()+"\nHorario de Início: "+ r.getHorario_inicio()+":00\nDuração: "+ r.getDuracao()+"\nStatus: "+ r.getStatus()+"\nAutorização: " + r.isAutorizacao();
        }
        return resposta;
    }
    public boolean removeReserva(Reserva r1) {
        return reservas.remove(r1);
    }
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
    
}
