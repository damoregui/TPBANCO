package edu.up.dao;

import edu.up.Entidades.Cuenta;
import java.util.ArrayList;
import java.util.List;

public class DaoObservable
{
    protected List<IObservadorDeDao> observadores ;

    public DaoObservable() 
    {
        this.observadores = new ArrayList<IObservadorDeDao>();
    }
      
    public void agregarObservador( IObservadorDeDao observador )
    {
        this.observadores.add( observador );
    }

    public void notificarBaja( String codigo )
    {
        for (IObservadorDeDao object : this.observadores )
        {
            object.bajaEnDao( codigo );
        }
    }

    public void notificarAlta( Cuenta cuenta )
    {
        for (IObservadorDeDao object : this.observadores )
        {
            object.altaEnDao( cuenta );
        }
    }

    public void notificarModificacion( Cuenta cuenta )
    {
        for (IObservadorDeDao object : this.observadores )
        {
            object.modificacionEnDao( cuenta );
        }
    }
}
