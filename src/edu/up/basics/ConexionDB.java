package edu.up.basics;

import com.sun.rowset.CachedRowSetImpl;
import edu.up.Excepciones.ExcepcionConexionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;

public class ConexionDB
{    
    private static ConexionDB instancia = null;
    
    private ConexionDB()
    {
    }
    
    public static ConexionDB getInstancia()
    {
        if( instancia == null )
        {
            instancia = new ConexionDB();
        }
        return instancia;
    }
    
    public void executeSQL(String sql) throws ExcepcionConexionDB
    {
        try
        {
            Connection c = DBManager.connect();
            try
            {
                Statement s = c.createStatement();
                s.executeUpdate(sql);
                c.commit();
            }
            catch (SQLException e)
            {
                c.rollback();
                throw e;
            }
            finally
            {
                c.close();
            }
        }
        catch ( SQLException ex )
        {
            throw new ExcepcionConexionDB( ex );
        }
    }

    public CachedRowSet ObtenerResultSet( String sql ) throws ExcepcionConexionDB
    {
        ResultSet rs = null;
        CachedRowSet e;
        
        try
        {
            Connection c = DBManager.connect();
        
            try
            {
                Statement s = c.createStatement();
                rs = s.executeQuery(sql);

                ArrayList<String> names = new ArrayList<String>();
                ArrayList<String> subjects = new ArrayList<String>();

                e = new CachedRowSetImpl(); 
                e.populate(rs);
            }
            finally
            {
                c.close();
            }
        }
        catch ( SQLException ex )
        {
            throw new ExcepcionConexionDB( ex );
        }

        return e;
    }
    
    public boolean avanzarResultSet( ResultSet rs ) throws ExcepcionConexionDB
    {
        boolean retorno;
        
        try
        {
            retorno = rs.next();
        }
        catch ( SQLException ex )
        {
            throw new ExcepcionConexionDB( ex );
        }
        
        return retorno;
    }
    
    public int obtenerValorResultSetInt( ResultSet rs, String campo ) throws ExcepcionConexionDB
    {
        int retorno;
        
        try
        {
            retorno = rs.getInt( campo );
        }
        catch ( SQLException ex )
        {
            throw new ExcepcionConexionDB( ex );
        }
        
        return retorno;
    }
    
    public String obtenerValorResultSetString( ResultSet rs, String campo ) throws ExcepcionConexionDB
    {
        String retorno;
        
        try
        {
            retorno = rs.getString( campo );
        }
        catch ( SQLException ex )
        {
            throw new ExcepcionConexionDB( ex );
        }
        
        return retorno;
    }

    public float obtenerValorResultSetFloat( ResultSet rs, String campo ) throws ExcepcionConexionDB
    {
        float retorno;
        
        try
        {
            retorno = rs.getFloat( campo );
        }
        catch ( SQLException ex )
        {
            throw new ExcepcionConexionDB( ex );
        }
        
        return retorno;
    }
}