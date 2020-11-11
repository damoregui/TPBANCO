package edu.up.dao;

import edu.up.Entidades.Cuenta;

public interface IObservadorDeDao
{
    void bajaEnDao( String codigo );
    void altaEnDao( Cuenta cuenta );
    void modificacionEnDao( Cuenta cuenta );
}
