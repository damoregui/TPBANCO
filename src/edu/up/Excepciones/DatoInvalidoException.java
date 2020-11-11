package edu.up.Excepciones;

public class DatoInvalidoException extends Exception
{
    public DatoInvalidoException( Exception excepcion )
    {
        super( "Dato invalido." + excepcion.getMessage() );
        this.initCause(excepcion);
    }
}
