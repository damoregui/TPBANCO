package edu.up.Negocio;

import edu.up.Entidades.Tarjeta;

public interface IObservadorDeBussinessObjectTarjeta
{
    void bajaTarjeta( String codigoTarjeta );
    void altaTarjeta( Tarjeta tarjeta);
    void modificacionTarjeta( Tarjeta tarjeta);
}
