package edu.up;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Logueos
{
    public static void loguear( String mensaje )
    {
        try
        {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("minibanco.log", true)));
            out.println( mensaje );
            out.close();
        }
        catch ( IOException ex )
        {
           ex.printStackTrace();
        }
    }
    
    public static void loguearExcepcion( Exception ex )
    {
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        ex.printStackTrace();
        String exceptionAsString = sw.toString();
        loguear( "------------------------------------------------" );
        loguear( ex.getMessage() );
        loguear( exceptionAsString );
        loguear( "------------------------------------------------" );
    }
}