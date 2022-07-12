package edu.up.dao;

import edu.up.Entidades.Tarjeta;


public interface IObservadorDeDaoTarjeta // La interfaz define comportamiento, cualquier objeto que implemente esta interfaz tiene que cumplir con el contrato (bajaendao, altaendao modificaciónendao que son "miembros")
{
    void altaEnDaoTarjeta( Tarjeta tarjeta ); // Che genere esta tarjeta. mirala
     void modificacionEnDaoTarjeta( Tarjeta tarjeta);// che modifique esta tarjeta y quedo asi   // identifies = nombre //  cuenta = nombre del parametro
     void bajaEnDaoTarjeta( String codigoTarjeta);

}

//A QUIENES TENGO QUE NOTIFICAR CUANDO SUCEDA