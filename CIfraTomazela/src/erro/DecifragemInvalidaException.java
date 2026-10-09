package erro;

public class DecifragemInvalidaException extends Exception {
    public DecifragemInvalidaException() {
      super("Mensagem decifrada incorreta. Tente novamente!");
    }
}
