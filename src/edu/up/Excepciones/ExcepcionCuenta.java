package edu.up.Excepciones;

public class ExcepcionCuenta extends Exception
{
    public ExcepcionCuenta( String mensaje, Exception excepcion )
    {
        super( mensaje );
        this.initCause(excepcion);
    }
}
