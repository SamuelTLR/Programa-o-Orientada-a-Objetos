package modelo;

import java.util.Locale;

public class Forca {
    private char letra;
    private String letra1;
    private String letra2;
    private String letra3;
    private String letra4;
    private String letra5;
    private String letra6;
    private String letra7;

    private String palavraSecreta;
    private int tentativasRestantes;
    private String letrasUsadas;

    public Forca() {
        this.tentativasRestantes = 15;
        this.letra = 'a';
        this.letra1 = "_";
        this.letra2 = "_";
        this.letra3 = "_";
        this.letra4 = "_";
        this.letra5 = "_";
        this.letra6 = "_";
        this.letra7 = "_";
        this.palavraSecreta = "";
        this.letrasUsadas = "";
    }

    public void limparTudo() {
        this.tentativasRestantes = 15;
        this.letra = 'a';
        this.letra1 = "_";
        this.letra2 = "_";
        this.letra3 = "_";
        this.letra4 = "_";
        this.letra5 = "_";
        this.letra6 = "_";
        this.letra7 = "_";
        this.palavraSecreta = "";
        this.letrasUsadas = "";
    }

    public void letraSelecionada(char valor) {
        letra = Character.toUpperCase(valor);
        boolean acertou = false;
        for(int i=0; i < this.palavraSecreta.length(); i++) {
            if (letra == this.palavraSecreta.charAt(i)) {
                acertou = true;
                switch (i) {
                    case 0:
                        letra1 = String.valueOf(letra);
                        break;
                    case 1:
                        letra2 = String.valueOf(letra);
                        break;
                    case 2:
                        letra3 = String.valueOf(letra);
                        break;
                    case 3:
                        letra4 = String.valueOf(letra);
                        break;
                    case 4:
                        letra5 = String.valueOf(letra);
                        break;
                    case 5:
                        letra6 = String.valueOf(letra);
                        break;
                    case 6:
                        letra7 = String.valueOf(letra);
                        break;
                }
            }
        }
        if(!acertou) {
            tentativasRestantes--;
        }
    }

    public void setPalavra(String palavra) {
        this.palavraSecreta = palavra.toUpperCase();
    }

    public String getPalavraRevelada() {
        String palavra = "" + letra1 + letra2 + letra3 +
                letra4 + letra5 + letra6 + letra7;
        return palavra;
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }

    public boolean ganhou() {
        String palavraRevelada = getPalavraRevelada();
        for(int i=0; i < palavraRevelada.length(); i++) {
            if (palavraRevelada.charAt(i) == '_') return false;
        }
        return true;
    }

    public boolean perdeu() {
        return tentativasRestantes <= 0;
    }

    public void reiniciar() {
        limparTudo();
        if(palavraSecreta != null) {
            setPalavra(palavraSecreta);
        }
    }
}
