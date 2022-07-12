package edu.up.Negocio;

import edu.up.Entidades.Cuenta;
import edu.up.Entidades.Tarjeta;

public interface IObservadorDeBussinessObject
{
    void baja( String codigo );
    void alta( Cuenta cuenta );
    void modificacion( Cuenta cuenta );
     void bajaTarjeta( String codigoTarjeta );
    void altaTarjeta( Tarjeta tarjeta);
    void modificacionTarjeta( Tarjeta tarjeta);
}
