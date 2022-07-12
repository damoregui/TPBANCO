package edu.up;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class Configuracion
{
    private static Configuracion instance = null;
   
        public String DB_DRIVER = "org.h2.Driver";
        public String DB_URL = "jdbc:h2:~/test";
        public String DB_USERNAME = "sa";

        public String DB_PASSWORD = "";
   
   
   private Configuracion()
   {
   }
   
   public static Configuracion getInstance()
   {
      if(instance == null)
      {
         instance = new Configuracion();

        File f = new File( "minibanco.cfg" ); // guardar configuración
        if( f.isFile() )
        {
           try
           {
                List<String> lines = Files.readAllLines( Paths.get( f.getPath()) );
                instance.DB_DRIVER = lines.get(0);
                instance.DB_URL = lines.get(1);
                instance.DB_USERNAME = lines.get(2);
                instance.DB_PASSWORD = lines.get(3);
           }
           catch ( IOException ex )
           {
               ex.printStackTrace();
           }
        }
        else
        {
            instance.DB_DRIVER = "org.h2.Driver";
            instance.DB_URL = "jdbc:h2:~/test";
            instance.DB_USERNAME = "sa";
            instance.DB_PASSWORD = "";

            try
            {
                 List<String> lines = new ArrayList<String>();
                 lines.add( instance.DB_DRIVER );
                 lines.add( instance.DB_URL );
                 lines.add( instance.DB_USERNAME );
                 lines.add( instance.DB_PASSWORD );
                 Files.write( Paths.get( f.getPath()) , lines );
            }
            catch ( Exception ex )
            {
                ex.printStackTrace();
            }
        }
      }

      return instance;
   }
}
