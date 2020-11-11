package edu.up.Excepciones;

public class ExcepcionConexionDB extends Exception
{
    public ExcepcionConexionDB( Exception excepcion )
    {
        super( "Se produjo un error de acceso a datos." );
        this.initCause(excepcion);

    }
}
