package edu.up.dao.impl;
import edu.up.dao.CuentaDAO;
import edu.up.Entidades.Cuenta;
import edu.up.Excepciones.ExcepcionConexionDB;
import edu.up.Excepciones.ExcepcionCuenta;
import edu.up.basics.ConexionDB;
import edu.up.dao.DaoObservable;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class CuentaDAOImpl extends DaoObservable implements CuentaDAO
{
    @Override
    public void insert(Cuenta cuenta) throws ExcepcionCuenta
    {
        String codigo = java.util.UUID.randomUUID().toString().replaceAll("-", "");

        String sql = "INSERT INTO cuentas (codigo, dni, nombre, tipocuenta, saldo, debito, credito) "
                + "VALUES ("
                + "'" + codigo + "', "
                + cuenta.getDni()+ ", "
                + "'" + cuenta.getNombre() + "', "
                + "'" + cuenta.getTipoCuenta()  +  "', "
                + "'" + cuenta.getSaldo() + "', "
                + "'" + cuenta.getDebito() + "', "
                + "'" + cuenta.getCredito() + "')";

 
        try
        {
            ConexionDB.getInstancia().executeSQL( sql );
            this.notificarAlta( cuenta );
        }
        catch ( ExcepcionConexionDB ex )
        {
            throw new ExcepcionCuenta( "Error al crear Cuenta", ex );
        }
    }
 
    @Override
    public void update(Cuenta cuenta) throws ExcepcionCuenta
    {
        String sql = "UPDATE cuentas "
                + "SET dni = " + cuenta.getDni()+ ", "
                + "nombre = '" + cuenta.getNombre()+ "', "
                + "tipocuenta = '" + cuenta.getTipoCuenta()+ "', "
                + "saldo = " + cuenta.getSaldo()+ " "
                + "debito = " + cuenta.getDebito()+ " "
                + "credito = " + cuenta.getCredito()+ " "
                + "WHERE codigo = '" + cuenta.getCodigo() +"'";

        try
        {
            ConexionDB.getInstancia().executeSQL( sql );
            this.notificarModificacion( cuenta );
        }
        catch ( ExcepcionConexionDB ex )
        {
            throw new ExcepcionCuenta( "Error al actualizar Cuenta", ex );
        }
    }
    
    @Override
    public void delete( Cuenta cuenta ) throws ExcepcionCuenta
    {
        String codigoEliminar = cuenta.getCodigo();
        String sql = "DELETE FROM cuentas WHERE Codigo = '" + codigoEliminar + "'";
        try
        {
            ConexionDB.getInstancia().executeSQL( sql );
            this.notificarBaja( codigoEliminar );
        }
        catch ( ExcepcionConexionDB ex )
        {
            throw new ExcepcionCuenta( "Error al eliminar Cuenta", ex );
        }
    }

    @Override
    public List<Cuenta> list() throws ExcepcionCuenta
    {
        List<Cuenta> results = new LinkedList<>();
        
        try
        {
            String sql = "SELECT * FROM cuentas";

            ResultSet rs = ConexionDB.getInstancia().ObtenerResultSet( sql );
        
            while ( ConexionDB.getInstancia().avanzarResultSet( rs ) )
            {
                results.add(new Cuenta(
                        ConexionDB.getInstancia().obtenerValorResultSetString(rs, "codigo" ),
                        ConexionDB.getInstancia().obtenerValorResultSetInt(rs, "dni" ),
                        ConexionDB.getInstancia().obtenerValorResultSetString(rs, "nombre" ),
                        ConexionDB.getInstancia().obtenerValorResultSetString(rs, "tipocuenta" ),
                        ConexionDB.getInstancia().obtenerValorResultSetFloat(rs, "saldo"),
                        ConexionDB.getInstancia().obtenerValorResultSetFloat(rs, "debito"),
                        ConexionDB.getInstancia().obtenerValorResultSetFloat(rs, "credito")));

            }
        }
        catch ( ExcepcionConexionDB ex )
        {
            throw new ExcepcionCuenta( "Error al obtener listado de Cuentas", ex );
        }

        return results;
    }


    // AGREGAR ACA LAS TRANSFERENCIAS ENTRE CUENTAS

    // CONSULTAR ES EXECUTE QUERY Y PARA EDITARBORRARAGREGAR ES EXECUTEUPDATE

    public List<Cuenta> list(int dni) throws ExcepcionCuenta
    {
        List<Cuenta> results = new LinkedList<>();
        try
        {
            String sql = "SELECT * FROM cuentas WHERE dni = " + dni ; // esto se llama autoboxing, lo sumo para hacer una query con un integer

            ResultSet rs = ConexionDB.getInstancia().ObtenerResultSet( sql );

            while ( ConexionDB.getInstancia().avanzarResultSet( rs ) )
            {
                results.add(new Cuenta(
                        ConexionDB.getInstancia().obtenerValorResultSetString(rs, "codigo" ),
                        ConexionDB.getInstancia().obtenerValorResultSetInt(rs, "dni" ),
                        ConexionDB.getInstancia().obtenerValorResultSetString(rs, "nombre" ),
                        ConexionDB.getInstancia().obtenerValorResultSetString(rs, "tipocuenta" ),
                        ConexionDB.getInstancia().obtenerValorResultSetFloat(rs, "saldo"),
                        ConexionDB.getInstancia().obtenerValorResultSetFloat(rs, "debito"),
                        ConexionDB.getInstancia().obtenerValorResultSetFloat(rs, "credito")));
            }
        }
        catch ( ExcepcionConexionDB ex )
        {
            throw new ExcepcionCuenta( "Error al obtener listado de Cuentas", ex );
        }

        return results;
    }

    public Cuenta get(String codigo) throws ExcepcionCuenta
    {
        List<Cuenta> results = new LinkedList<>();

        Cuenta result = null;
        try
        {
            String sql = "SELECT * FROM cuentas WHERE codigo = '" + codigo + "'" ; // esto se llama autoboxing, lo sumo para hacer una query con un integer


            ResultSet rs = ConexionDB.getInstancia().ObtenerResultSet( sql );

            while ( ConexionDB.getInstancia().avanzarResultSet( rs ) )
            {
                results.add(new Cuenta(
                        ConexionDB.getInstancia().obtenerValorResultSetString(rs, "codigo" ),
                        ConexionDB.getInstancia().obtenerValorResultSetInt(rs, "dni" ),
                        ConexionDB.getInstancia().obtenerValorResultSetString(rs, "nombre" ),
                        ConexionDB.getInstancia().obtenerValorResultSetString(rs, "tipocuenta" ),
                        ConexionDB.getInstancia().obtenerValorResultSetFloat(rs, "saldo"),
                        ConexionDB.getInstancia().obtenerValorResultSetFloat(rs, "debito"),
                        ConexionDB.getInstancia().obtenerValorResultSetFloat(rs, "credito")));
            }


        }
        catch ( IndexOutOfBoundsException ex ){
            throw new ExcepcionCuenta("La cuenta seleccionada no existe", ex);
        }
        catch ( ExcepcionConexionDB ex )
        {
            throw new ExcepcionCuenta( "Error al obtener listado de Cuentas", ex );
        }

        //obtener el primer elemento de results (si existe) y asignárselo a result para que el return de abajo lo devuelva
        result = results.get(0) ;
        return result;
    }
}
