package forma;
import java.util.ArrayList;
public class Espaco2D {
    ArrayList<Forma> formas = new ArrayList<>();

    public boolean adicionarForma(Forma d) {
        return formas.add(d);
    }
    public double calcularAreaTotal(){
        Ponto2D[] pontos; 
        double areaT = 0.0;
        
        for(int i = 0; i < formas.size(); i++) {
            pontos = formas.get(i).getPontos();
            areaT += formas.get(i).calcularArea(pontos);
        }
        return areaT;
    }

    public double calcularPerimetroTotal(){
        Ponto2D[] pontos; 
        double perimetroT = 0.0;
        
        for(int i = 0; i < formas.size(); i++) {
            pontos = formas.get(i).getPontos();
            perimetroT += formas.get(i).Perimetro(pontos);
        }
        return perimetroT;
    }
    public String mostrarTipoTriangulo() {
        Ponto2D[] pontos; 
        String tipo = "";
        
        for(int i = 0; i < formas.size(); i++) {
            if(formas.get(i) instanceof Triangulo) {
                Triangulo t = (Triangulo) formas.get(i);
                pontos = t.getPontos();
                if(pontos == null) {
                }else {
                    System.out.println("Pontos do triângulo:");
                    for (Ponto2D ponto : pontos) {
                        tipo += "(" + ponto.getX() + ", " + ponto.getY() + ")";

                    }
                    tipo += " "+ t.tipoTriangulo() + '\n';
                }
            }
        }
        return tipo;
    }
}
