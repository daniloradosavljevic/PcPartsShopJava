package poslovnedomaci.exception;

public class DomaciException extends Exception {

    public DomaciException(String message) {
        super(message);
    }

    public DomaciException(String message, Throwable cause) {
        super(message, cause);
    }
}
