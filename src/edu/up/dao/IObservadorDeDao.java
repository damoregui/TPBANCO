package edu.up.dao;

import edu.up.Entidades.Cuenta;
import edu.up.Entidades.Tarjeta;


public interface IObservadorDeDao
{
    void bajaEnDao( String codigo ); // Lo que recibe el event handler acerca del evento. LA "METADATA" del evento.
    void altaEnDao( Cuenta cuenta ); // Che genere esta cuenta. mirala
    void modificacionEnDao( Cuenta cuenta); // che modifique esta cuenta y quedo asi   // identifies = nombre //  cuenta = nombre del parametro
    void transferenciaEnDao( Cuenta cuenta); // che modifique esta cuenta y quedo asi   // identifies = nombre //  cuenta = nombre del parametro

}

//A QUIENES TENGO QUE NOTIFICAR CUANDO SUCEDA