package edu.up;

import edu.up.Excepciones.ExcepcionConexionDB;
import edu.up.basics.TableManager;
import edu.up.ui.Vistas.HandlerAplicacion;
import edu.up.ui.Vistas.MenuPrincipal;
import edu.up.ui.Vistas.MenuPrincipalUser;

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
       // MenuPrincipalUser menu2 = new MenuPrincipalUser();
        MenuPrincipal menu = new MenuPrincipal();

      //  HandlerAplicacion handler2 = new HandlerAplicacion(menu2);
        HandlerAplicacion handler = new HandlerAplicacion(menu);

        menu.mostrar();
       // menu2.mostrar();
        
    }
}


