package principal_Samuel_Tomazela;
public class App {
    public static void main(String[] args) throws Exception {
        Morador Samuel = new Morador("Samuel", "(31) 995956665", 301);
        Morador Pedro = new Morador("Pedro", "(31) 93859992", 101);
        Morador Filipe = new Morador("Filipe", "(31) 987605486", 202);
        Reserva r1 = new Reserva("10/11/2025",12, 2);
        Reserva r2 = new Reserva("11/12/2025", 12, 3);
        Reserva r3 = new Reserva("10/11/2025", 12, 1);
        Reserva r4 = new Reserva("10/11/2025", 15, 4);
        Reserva r5 = new Reserva("12/12/2025", 25, 26);
        Sistema s1 = new Sistema();
        Administrador Dilma = new Administrador("Dilma", 01);
        Administrador Lula = new Administrador("Lula", 13);

        Samuel.addReserva(r1, s1);
        Pedro.addReserva(r3, s1);
        Filipe.addReserva(r2, s1);
        Filipe.addReserva(r4, s1);
        Filipe.addReserva(r5, s1);

        System.out.println(s1);
        Dilma.Autorizar(r1, s1);
        System.out.println(s1);
        
    }
    
}
