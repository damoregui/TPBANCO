package edu.up.dao;

import edu.up.Entidades.Cuenta;
import edu.up.Entidades.Tarjeta;

import java.util.ArrayList;
import java.util.List;

public class DaoObservableTarjeta // Clase
{
    protected List<IObservadorDeDaoTarjeta> observadores ;

    public DaoObservableTarjeta() // Constructor
    {
        this.observadores = new ArrayList<IObservadorDeDaoTarjeta>(); // inicializa con una lista vacia y puede contener tipos de datos IbservadorDeDao
    }
      
    public void agregarObservador( IObservadorDeDaoTarjeta observador ) //Recibe el tipo de dato IobservadorDeDao y lo agrega a la lista // Mi bussiness object es cuenta
    {
        this.observadores.add( observador );
    }

  public void notificarAltaTarjeta( Tarjeta tarjeta ) {
      for (IObservadorDeDaoTarjeta object : this.observadores) {
          object.altaEnDaoTarjeta(tarjeta);
      }
  }
  public void notificarModificacionTarjeta( Tarjeta tarjeta )
      {
          for (IObservadorDeDaoTarjeta object : this.observadores) {
              object.modificacionEnDaoTarjeta(tarjeta);
          }
      }
  public void notificarBajaTarjeta( String codigo ) {
      for (IObservadorDeDaoTarjeta object : this.observadores) {
          object.bajaEnDaoTarjeta(codigo);
      }
  }
}
