package edu.up.dao;

import edu.up.Entidades.Tarjeta;


public interface IObservadorDeDaoTarjeta
{
    void altaEnDaoTarjeta( Tarjeta tarjeta ); // Che genere esta tarjeta. mirala
     void bajaEnDaoTarjeta( String codigoTarjeta);

}

//A QUIENES TENGO QUE NOTIFICAR CUANDO SUCEDA