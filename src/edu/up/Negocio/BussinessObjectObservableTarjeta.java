package edu.up.Negocio;
import edu.up.Entidades.Tarjeta;
import java.util.ArrayList;
import java.util.List;

public class BussinessObjectObservableTarjeta
{
    protected List<IObservadorDeBussinessObjectTarjeta> observadores ;

    public BussinessObjectObservableTarjeta()
    {
        this.observadores = new ArrayList<IObservadorDeBussinessObjectTarjeta>();
    }
    
    public void agregarObservador( IObservadorDeBussinessObjectTarjeta observador )
    {
        this.observadores.add( observador );
    }

    public void notificarBaja(  String codigoTarjeta )
    {
        for (IObservadorDeBussinessObjectTarjeta object : this.observadores )
        {
            object.bajaTarjeta( codigoTarjeta );
        }
    }

    public void notificarAlta( Tarjeta tarjeta )
    {
        for (IObservadorDeBussinessObjectTarjeta object : this.observadores )
        {
            object.altaTarjeta( tarjeta );
        }
    }
    
   // public void notificarModificacion( Tarjeta tarjeta )
   // {
   //     for (IObservadorDeBussinessObjectTarjeta object : this.observadores )
   //     {
   //         object.modificacionTarjeta( cuenta );
   //     }
   // }

   public void notificarAltaTarjeta( Tarjeta tarjeta ) {
       for (IObservadorDeBussinessObjectTarjeta object : this.observadores) {
           object.altaTarjeta(tarjeta);
       }
   }

   public void notificarBajaTarjeta(  String codigoTarjeta ) {
       for (IObservadorDeBussinessObjectTarjeta object : this.observadores) {
           object.bajaTarjeta(codigoTarjeta);
       }
   }

   public void notificarModificacionTarjeta( Tarjeta tarjeta )
   {
       for (IObservadorDeBussinessObjectTarjeta object : this.observadores )
       {
           object.modificacionTarjeta( tarjeta );
       }
   }
}
