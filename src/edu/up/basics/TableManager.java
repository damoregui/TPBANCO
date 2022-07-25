package edu.up.basics;
import edu.up.Excepciones.ExcepcionConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

    public static void createtable() throws ExcepcionConexionDB
    {
        String sql = "CREATE TABLE IF NOT EXISTS cuentas ( codigo VARCHAR(40), nombre VARCHAR(256), dni INTEGER, tipocuenta VARCHAR(2), saldo DECIMAL( 15,4), debito DECIMAL( 15,4), credito DECIMAL( 15,4))";
        String sql2 = "CREATE TABLE IF NOT EXISTS tarjetas ( codigoTarjeta VARCHAR(40), dnipropietario INTEGER, limite DECIMAL( 15,4), saldotarjeta DECIMAL (15,4) )";
        // String sql3 = "CREATE TABLE IF NOT EXISTS users ( codigoUsuario VARCHAR(40), dniusuario INTEGER, tipousuario VARCHAR(40), nombreusuario VARCHAR(40) )";
        String sql4 = "CREATE TABLE IF NOT EXISTS movimientos (codigomov VARCHAR(40), codigoCuenta VARCHAR(40), tipoMov VARCHAR(40), monto DECIMAL (15 ,4) )";
        ConexionDB.getInstancia().executeSQL( sql );
        ConexionDB.getInstancia().executeSQL( sql2 );
       // ConexionDB.getInstancia().executeSQL( sql3 );
        ConexionDB.getInstancia().executeSQL( sql4 );

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
