package edu.up.Negocio;

import edu.up.dao.CuentaDAO;
import edu.up.Entidades.Cuenta;
import edu.up.Excepciones.ExcepcionCuenta;
import edu.up.dao.IObservadorDeDao;
import edu.up.dao.impl.CuentaDAOImpl;
import java.util.List;

public class CuentaBO extends BussinessObjectObservable implements IObservadorDeDao
{
    private final CuentaDAO cuentaDao;

    public CuentaBO()
    {
        this.cuentaDao = new CuentaDAOImpl();
        this.cuentaDao.agregarObservador( this );
    }
    
    public CuentaBO( CuentaDAO dao )
    {
        this.cuentaDao = dao;
        this.cuentaDao.agregarObservador( this );
    }
    
    public void grabar( Cuenta cuenta ) throws ExcepcionCuenta
    {
        if ( cuenta.getCodigo().equals("") )
        {
            cuentaDao.insert(cuenta);
        }
        else
        {
            cuentaDao.update(cuenta);
        }
    }

    public void eliminarCuenta(Cuenta cuenta) throws ExcepcionCuenta
    {
        cuentaDao.delete( cuenta );
    }

    public List<Cuenta> listarCuentas() throws ExcepcionCuenta
    {
        return cuentaDao.list();
    }

    @Override
    public void altaEnDao( Cuenta cuenta )
    {
        this.notificarAlta( cuenta );
    }

    @Override
    public void bajaEnDao( String codigo )
    {
        this.notificarBaja( codigo );
    }

    @Override
    public void modificacionEnDao( Cuenta cuenta )
    {
        this.notificarModificacion( cuenta );
    }
}