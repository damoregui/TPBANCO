package edu.up.basics;
import edu.up.Excepciones.ExcepcionConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

    public static void createtable() throws ExcepcionConexionDB
    {
        String sql = "CREATE TABLE IF NOT EXISTS cuentas ( codigo VARCHAR(40), nombre VARCHAR(256), dni INTEGER, tipocuenta VARCHAR(2), saldo DECIMAL( 15,4) )";
        ConexionDB.getInstancia().executeSQL( sql );
    }
	
    public static void droptable() throws ExcepcionConexionDB
    {
        Connection c = DBManager.connect();
        String sql = "DROP TABLE ConsultaDeCuentas";

        try
        {
                Statement s = c.createStatement();
                s.execute(sql);
                c.commit();
        }
        catch (SQLException e)
        {
            try
            {
                c.rollback();
            }
            catch (SQLException e1)
            {
                e1.printStackTrace();
            }
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
