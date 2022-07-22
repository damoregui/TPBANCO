package edu.up.Excepciones;

public class DatoInvalidoException extends Exception
{
    public DatoInvalidoException(String message) {
        super(message);
    }

    public DatoInvalidoException( String message, Exception cause )
    {
        super( message, cause);
    }
}
