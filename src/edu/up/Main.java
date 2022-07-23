package edu.up;

import edu.up.Excepciones.ExcepcionConexionDB;
import edu.up.basics.TableManager;
import edu.up.ui.Vistas.HandlerAplicacion;
import edu.up.ui.Vistas.MenuPrincipal;
import edu.up.ui.Vistas.MenuPrincipalUser;

public class Main
{
    public static final MenuPrincipalUser menuUsuario = new MenuPrincipalUser();
    public static final MenuPrincipal menuAdministrador = new MenuPrincipal();
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

        //new HandlerAplicacion(menuUsuario);
        //new HandlerAplicacion(menuAdministrador);
        menuUsuario.ocultar();
        menuAdministrador.mostrar();
        
    }
}


