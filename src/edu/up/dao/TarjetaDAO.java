package edu.up.dao;

import edu.up.Entidades.Tarjeta;
import edu.up.Excepciones.ExcepcionTarjeta;
import java.util.List;

public interface TarjetaDAO {

    void insert(Tarjeta tarjeta) throws ExcepcionTarjeta;
    void delete(Tarjeta tarjeta) throws ExcepcionTarjeta;
    void update(Tarjeta tarjeta) throws ExcepcionTarjeta;
    List<Tarjeta> list() throws ExcepcionTarjeta;

    List<Tarjeta> list(int dni) throws ExcepcionTarjeta;
    
    void agregarObservador( IObservadorDeDaoTarjeta observador );
    void notificarBaja( String codigoTarjeta ) throws ExcepcionTarjeta;
    void notificarAlta( Tarjeta tarjeta ) throws ExcepcionTarjeta;
}