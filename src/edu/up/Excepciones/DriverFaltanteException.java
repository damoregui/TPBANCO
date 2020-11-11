/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.up.Excepciones;

/**
 *
 * @author czamorano
 */
public class DriverFaltanteException extends Exception
{
    public DriverFaltanteException( String driver, Exception excepcion )
    {
        super("No se encuentra el driver " + driver + " de conexion a la base de datos." );
        this.initCause( excepcion );
    }
}
