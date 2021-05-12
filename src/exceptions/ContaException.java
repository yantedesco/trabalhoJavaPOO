package exceptions;

public class ContaException extends Exception {

    private static final long serialVersionUID = 1L;

    public ContaException() {
        super();
    }

    public ContaException(String mensagem) {
        super(mensagem);
    }

    public ContaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public ContaException(Throwable causa) {
        super(causa);
    }
}
