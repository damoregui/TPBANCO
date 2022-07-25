package edu.up.Negocio;

import edu.up.Entidades.Movimiento;
import edu.up.dao.CuentaDAO;
import edu.up.Entidades.Cuenta;
import edu.up.Excepciones.ExcepcionCuenta;
import edu.up.dao.IObservadorDeDao;
import edu.up.dao.impl.CuentaDAOImpl;

import java.util.List;

public class CuentaBO extends BussinessObjectObservable implements IObservadorDeDao // el implents hace referencia a interfaz. IObservadorDeDao define solamente comportamiento . Me define los mètodos que tiene que tener cualqueir clse que quiera ser observadora de un dao
{
    private final CuentaDAO cuentaDao;

    public CuentaBO() {
        this.cuentaDao = new CuentaDAOImpl();
        this.cuentaDao.agregarObservador(this);
    }

    public CuentaBO(CuentaDAO dao) {
        this.cuentaDao = dao;
        this.cuentaDao.agregarObservador(this);
    }

    public void grabar(Cuenta cuenta) throws ExcepcionCuenta {
        if (cuenta.getCodigo().equals("")) {
            cuentaDao.insert(cuenta);
        } else {
            cuentaDao.update(cuenta);
        }
    }

    public void eliminarCuenta(Cuenta cuenta) throws ExcepcionCuenta {
        cuentaDao.delete(cuenta);
    }

    public List<Cuenta> listarCuentas() throws ExcepcionCuenta {
        return cuentaDao.list();
    }

    public List<Cuenta> listarCuentas(int dni) throws ExcepcionCuenta { //esto es sobrecarga
        return cuentaDao.list(dni);
    }

    public Cuenta devolverCuenta(String codigo) throws ExcepcionCuenta {
        return cuentaDao.devolverCuenta(codigo);
    }

    @Override
    public void altaEnDao(Cuenta cuenta) {
        this.notificarAlta(cuenta);
    }

    @Override
    public void bajaEnDao(String codigo) {
        this.notificarBaja(codigo);
    }

    @Override
    public void modificacionEnDao(Cuenta cuenta) {
        this.notificarModificacion(cuenta);
    }

    @Override
    public void transferenciaEnDao(Cuenta cuenta) {
        this.notificarTransferencia(cuenta);
    }

    public void transferirMonto(Cuenta cuentaOrigen, Cuenta cuentaDestino, float monto) throws ExcepcionCuenta {
        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);
        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
        cuentaDao.transfer(cuentaOrigen, cuentaDestino);
        Movimiento movimientoOrigen = new Movimiento(cuentaOrigen.getCodigo(), null, "DEBITO", monto);
        cuentaDao.insertMovimiento(movimientoOrigen);
        Movimiento movimientoDestino = new Movimiento(cuentaDestino.getCodigo(), null, "CREDITO", monto);
        cuentaDao.insertMovimiento(movimientoDestino);
    }
}