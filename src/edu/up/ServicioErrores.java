package edu.up;

import java.util.ArrayList;
import java.util.List;

public class ServicioErrores
{
    private static ServicioErrores instancia = null;
    
    private ServicioErrores()
    {
    }
    
    public static ServicioErrores getInstancia()
    {
        if( instancia == null )
        {
            instancia = new ServicioErrores();
        }
        return instancia;
    }
    
    public void informarError( Exception ex )
    {
        List<String> mensajes = this.obtenerInformacion( ex );
        
        Mensajeria.getInstancia().MostrarError( String.join("\r\n", mensajes ) );
        Logueos.loguearExcepcion( ex );
    }
 
    private List<String> obtenerInformacion(Throwable e)
    {
        List<String> retorno = new ArrayList<String>();
                
        retorno.add( e.getMessage() );

        Throwable cause = null; 
        Throwable result = e;

        while(null != (cause = result.getCause())  && (result != cause) ) {
            result = cause;
            retorno.add( cause.getMessage() );
        }
                
        return retorno;
    }
}