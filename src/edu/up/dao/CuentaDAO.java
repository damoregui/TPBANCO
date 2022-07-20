package edu.up.dao;

import edu.up.Entidades.Cuenta;
import edu.up.Excepciones.ExcepcionCuenta;
import java.util.List;

//=====================================================================================\\
// acá se declaran los comportamientos que tendrán las cuentas                         ||
// Es parecido al polimorfismo APROX. Pero no heredan del mismo lado absolutamente nada||
//=====================================================================================//

public interface CuentaDAO {

    void insert(Cuenta cuenta) throws ExcepcionCuenta;
    void delete(Cuenta cuenta) throws ExcepcionCuenta;
    void update(Cuenta cuenta) throws ExcepcionCuenta;
    List<Cuenta> list() throws ExcepcionCuenta;
    List<Cuenta> list(int dni) throws ExcepcionCuenta;

    void agregarObservador( IObservadorDeDao observador );
    void notificarBaja( String codigo ) throws ExcepcionCuenta;
    void notificarAlta( Cuenta cuenta ) throws ExcepcionCuenta;
    void notificarModificacion( Cuenta cuenta ) throws ExcepcionCuenta;
}