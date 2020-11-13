package edu.up.dao;

import edu.up.Entidades.Cuenta;
import edu.up.Excepciones.ExcepcionCuenta;

import java.util.List;

public interface CuentaDAO {

    void insert(Cuenta cuenta) throws ExcepcionCuenta;
    void delete(Cuenta cuenta) throws ExcepcionCuenta;
    void update(Cuenta cuenta) throws ExcepcionCuenta;
    List<Cuenta> list() throws ExcepcionCuenta;
    
    void agregarObservador( IObservadorDeDao observador );
    void notificarBaja( String codigo ) throws ExcepcionCuenta;
    void notificarAlta( Cuenta cuenta ) throws ExcepcionCuenta;
    void notificarModificacion( Cuenta cuenta ) throws ExcepcionCuenta;
}