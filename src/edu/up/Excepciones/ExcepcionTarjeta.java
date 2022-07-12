package edu.up.Excepciones;

public class ExcepcionTarjeta extends Exception
{
    public ExcepcionTarjeta(String mensaje, Exception excepcion )
    {
        super( mensaje );
        this.initCause(excepcion);
    }
}
