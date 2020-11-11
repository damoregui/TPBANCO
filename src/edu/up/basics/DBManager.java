package edu.up.basics;
import edu.up.Configuracion;
import edu.up.Excepciones.ExcepcionConexionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBManager {

	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_URL = "jdbc:h2:~/test";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";
	
	public static Connection connect() throws ExcepcionConexionDB
        {
            String driver = Configuracion.getInstance().DB_DRIVER;
            Connection c = null;

            try
            {
                Class.forName( Configuracion.getInstance().DB_DRIVER );
                c =  DriverManager.getConnection( Configuracion.getInstance().DB_URL, Configuracion.getInstance().DB_USERNAME, Configuracion.getInstance().DB_PASSWORD);
                c.setAutoCommit(false);
            }
            catch (SQLException e) 
            {
                throw new ExcepcionConexionDB( e );
            }
            catch (ClassNotFoundException e) 
            {
                throw new ExcepcionConexionDB( e );
            }

            return c;
	}
	
	public static void shutdown() throws Exception {
		Connection c = connect();
		Statement s = c.createStatement();
		s.execute("SHUTDOWN");
		c.close();
	}
	
}
