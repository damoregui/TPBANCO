package edu.up.Negocio;

import edu.up.Entidades.Cuenta;

public interface IObservadorDeBussinessObject
{
    void baja( String codigo );
    void alta( Cuenta cuenta );
    void modificacion( Cuenta cuenta );
}
