package modelo;

public class Calculadora {

    private String operando1;
    private String operando2;
    private String operacao;
    private double resultado;
    private String visor;

    public Calculadora() {
        this.operacao = "";
        this.operando1 = "";
        this.operando2 = "";
        this.visor = "";
        this.resultado = 0;
    }

    public void concatenarValor(String valor) {
        if (valor.equals(".")) {
            if(operacao.equals("")){
                if(!operando1.contains(".")){
                    if (operando1.isEmpty()) {
                        operando1 = "0.";
                    } else {
                        operando1 += valor;
                    }
                    visor = operando1;
                }
            } else {
                if(!operando2.contains(".")) {
                    if (operando2.isEmpty()) {
                        operando2 = "0.";
                    } else {
                        operando2 += valor;
                    }
                    visor = operando1 + operacao + operando2;
                }
            } 
        } else {
            // Números normais
            if (operacao.equals("")) {
                operando1 += valor;
                visor = operando1;
            } else {
                operando2 += valor;
                visor = operando1 + operacao + operando2;
            }
        }
    }

    public void decidirAcao(String valor) {
        if (valor.equals("C")) {
            limparTudo();
        }
        if(valor.equals("CE")) {
            if(!(operando2.equals(""))) {
                operando2 = "";
                visor = operando1 + operacao;
            }else if (!(operacao.equals(""))) {
                operacao = "";
                visor = operando1;
            } else {
                operando2 = "";
                operacao = "";
                visor = "";
            }
        }
        if (valor.equals("/") || 
            valor.equals("+") || 
            valor.equals("*") || 
            valor.equals("-") ||
            valor.equals("X²")||
            valor.equals("%")) {
            operacao = valor;
            visor = operando1 + operacao;
        }
        if (valor.equals("=")) {
            if (operacao.equals("+")) {
                resultado = Double.valueOf(operando1) + Double.valueOf(operando2);
            }

            if (operacao.equals("/")) {
                resultado = Double.valueOf(operando1) / Double.valueOf(operando2);
            }

            if (operacao.equals("*")) {
                resultado = Double.valueOf(operando1) * Double.valueOf(operando2);
            }

            if (operacao.equals("-")) {
                resultado = Double.valueOf(operando1) - Double.valueOf(operando2);
            }

            if (operacao.equals("%")) {
                resultado = Double.valueOf(operando1) % Double.valueOf(operando2);
            }

            if (operacao.equals("X²")) {
                resultado = Math.pow(Double.valueOf(operando1) ,2);
            }

            operando1 = String.valueOf(resultado);
            operando2 = "";
            visor = String.valueOf(resultado);
        }

    }

    public void limparTudo() {
        this.operacao = "";
        this.operando1 = "";
        this.operando2 = "";
        this.visor = "";
        this.resultado = 0;
    }

    public String getVisor() {
        return visor;
    }

}
