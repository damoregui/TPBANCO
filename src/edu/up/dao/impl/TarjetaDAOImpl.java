package edu.up.dao.impl;
import edu.up.Entidades.Tarjeta;
import edu.up.Excepciones.ExcepcionConexionDB;
import edu.up.Excepciones.ExcepcionTarjeta;
import edu.up.basics.ConexionDB;
import edu.up.dao.DaoObservableTarjeta;
import edu.up.dao.IObservadorDeDaoTarjeta;
import edu.up.dao.TarjetaDAO;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class TarjetaDAOImpl extends DaoObservableTarjeta implements TarjetaDAO
{
    @Override
    public void insert(Tarjeta tarjeta) throws ExcepcionTarjeta
    {
        String codigoTarjeta = java.util.UUID.randomUUID().toString().replaceAll("-", "");

        String sql = "INSERT INTO tarjetas (codigoTarjeta, dnipropietario, limite, saldotarjeta) "
                + "VALUES ("
                + "'" + codigoTarjeta + "', "
                + tarjeta.getDniPropietario()+ ", "
                + "'" + tarjeta.getLimite() + "', "
                + tarjeta.getSaldoTarjeta() + ")";
 
        try
        {
            ConexionDB.getInstancia().executeSQL( sql );
            this.notificarAlta( tarjeta );
        }
        catch ( ExcepcionConexionDB ex )
        {
            throw new ExcepcionTarjeta( "Error al generar tarjeta de crédito: ", ex );
        }
    }

    @Override
    public void update(Tarjeta tarjeta) throws ExcepcionTarjeta
    {
        String sql = "UPDATE tarjetas "
                + "SET dnipropietario =  " + tarjeta.getDniPropietario()+ ", "
                + "SET codigo = '" + tarjeta.getCodigoTarjeta()+ "', "
                + "SET limite = '" + tarjeta.getLimite()+ "', "
                + "saldotarjeta = '" + tarjeta.getSaldoTarjeta()+ "', "
                + "WHERE dnipropietario = '" + tarjeta.getCodigoTarjeta() +"'";

        try
        {
            ConexionDB.getInstancia().executeSQL( sql );
            //this.notificarModificacion( tarjeta );
        }
        catch ( ExcepcionConexionDB ex )
        {
            throw new ExcepcionTarjeta( "Error al hacer update al registro de la tarjeta", ex );
        }
    }
    
    @Override
    public void delete( Tarjeta tarjeta ) throws ExcepcionTarjeta
    {
        String codigoEliminar = tarjeta.getCodigoTarjeta();
        String sql = "DELETE FROM tarjetas WHERE codigoTarjeta = '" + codigoEliminar + "'";
        try
        {
            ConexionDB.getInstancia().executeSQL( sql );
            this.notificarBaja( codigoEliminar );
        }
        catch ( ExcepcionConexionDB ex )
        {
            throw new ExcepcionTarjeta( "Error al eliminar Tarjeta de la persona", ex );
        }
    }

    @Override
    public List<Tarjeta> list() throws ExcepcionTarjeta
    {
        List<Tarjeta> resultstarjeta = new LinkedList<>();
        
        try
        {
            String sql = "SELECT * FROM tarjetas";

            ResultSet rs = ConexionDB.getInstancia().ObtenerResultSet( sql );
        
            while ( ConexionDB.getInstancia().avanzarResultSet( rs ) )
            {
                resultstarjeta.add(new Tarjeta(
                        ConexionDB.getInstancia().obtenerValorResultSetInt(rs, "dnipropietario" ),
                        ConexionDB.getInstancia().obtenerValorResultSetFloat(rs, "limite" ),
                        ConexionDB.getInstancia().obtenerValorResultSetFloat(rs, "saldotarjeta")));
            }
        }
        catch ( ExcepcionConexionDB ex )
        {
            throw new ExcepcionTarjeta( "Error al obtener listado de Tarjetas", ex );
        }

        return resultstarjeta;
    }

    //COMPLETAR EL LIST POR DNI
    @Override
    public List<Tarjeta> list(int dni) throws ExcepcionTarjeta {
        return null;
    }
}
