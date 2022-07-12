package edu.up.Negocio;

import edu.up.Entidades.Cuenta;
import edu.up.Entidades.Tarjeta;
import java.util.ArrayList;
import java.util.List;

public class BussinessObjectObservable
{
    protected List<IObservadorDeBussinessObject> observadores ;

    public BussinessObjectObservable() 
    {
        this.observadores = new ArrayList<IObservadorDeBussinessObject>();
    }
    
    public void agregarObservador( IObservadorDeBussinessObject observador )
    {
        this.observadores.add( observador );
    }

    public void notificarBaja(  String codigo )
    {
        for (IObservadorDeBussinessObject object : this.observadores )
        {
            object.baja( codigo );
        }
    }

    public void notificarAlta( Cuenta cuenta )
    {
        for (IObservadorDeBussinessObject object : this.observadores )
        {
            object.alta( cuenta );
        }
    }
    
    public void notificarModificacion( Cuenta cuenta )
    {
        for (IObservadorDeBussinessObject object : this.observadores )
        {
            object.modificacion( cuenta );
        }
    }

   public void notificarAltaTarjeta( Tarjeta tarjeta ) {
       for (IObservadorDeBussinessObject object : this.observadores) {
           object.altaTarjeta(tarjeta);
       }
   }

   public void notificarBajaTarjeta(  String codigoTarjeta ) {
       for (IObservadorDeBussinessObject object : this.observadores) {
           object.bajaTarjeta(codigoTarjeta);
       }
   }

   public void notificarModificacionTarjeta( Tarjeta tarjeta )
   {
       for (IObservadorDeBussinessObject object : this.observadores )
       {
           object.modificacionTarjeta( tarjeta );
       }
   }
}
