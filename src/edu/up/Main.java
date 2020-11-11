package edu.up;

import edu.up.Excepciones.ExcepcionConexionDB;
import edu.up.basics.TableManager;
import edu.up.ui.Vistas.HandlerAplicacion;
import edu.up.ui.Vistas.MenuPrincipal;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            TableManager.createtable();
        }
        catch ( ExcepcionConexionDB ex )
        {
            ServicioErrores.getInstancia().informarError( ex );
            System.exit(0);
        }
        MenuPrincipal menu = new MenuPrincipal();

        HandlerAplicacion handler = new HandlerAplicacion( menu );
        
        menu.mostrar();
        
        
    }
}


