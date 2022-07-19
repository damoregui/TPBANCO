package edu.up.Negocio;

import edu.up.dao.CuentaDAO;
import edu.up.Entidades.Cuenta;
import edu.up.Excepciones.ExcepcionCuenta;
import edu.up.dao.IObservadorDeDao;
import edu.up.dao.impl.CuentaDAOImpl;
import java.util.List;

public class CuentaBO extends BussinessObjectObservable implements IObservadorDeDao // el implents hace referencia a interfaz. IObservadorDeDao define solamente comportamiento . Me define los mètodos que tiene que tener cualqueir clse que quiera ser observadora de un dao
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

    public List<Cuenta> listarCuentasPorDni(int dni) throws ExcepcionCuenta{
        return cuentaDao.list(dni);
    }

    //VER CON JOTA EL LISTAR CUENTA POR DNI


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

    public void transferirMonto (Cuenta cuentaOrigen, Cuenta cuentaDestino, float monto) throws ExcepcionCuenta {
        if (cuentaOrigen.getSaldo() >= monto) {
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);
            cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
            cuentaDao.update(cuentaOrigen);
            cuentaDao.update(cuentaDestino);
        } else {
            //Mostrar mensaje de error por monto
        }
    }
}