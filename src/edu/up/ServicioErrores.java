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
        Mensajeria.getInstancia().mostrarError(ex.getMessage() );
        Logueos.loguearExcepcion( ex );
    }

    public void informarError( Exception ex, String mensajeError )
    {
        Mensajeria.getInstancia().mostrarError(mensajeError + ex.getMessage()  );
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