package principal_Samuel_Tomazela;

public class Reserva {
    private String data;
    private int horario_inicio;
    private int duracao;
    private String status;
    private boolean autorizacao;

    public Reserva() {
        data = "";
        horario_inicio = 0;
        status = "Pendente";
        duracao = 0;
        autorizacao = false;
    }

    public Reserva(String data, int horario, int duracao) {
        this.data = data;
        this.horario_inicio = horario % 24;
        status = "Pendente";
        autorizacao = false;
        this.duracao = duracao % 23;
    }
    public String getData() {
        return data;
    }

    public int getHorario_inicio() {
        return horario_inicio;
    }

    public void setHorario_inicio(int horario_inicio) {
        this.horario_inicio = horario_inicio % 24;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao % 23;
    }

    public void setData(String data) {
        this.data = data;
    }


    public boolean isAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(boolean autorizacao) {
        this.autorizacao = autorizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
