package edu.up.dao;

import edu.up.Entidades.Cuenta;
import java.util.ArrayList;
import java.util.List;

public class DaoObservable // Clase
{
    protected List<IObservadorDeDao> observadores;

    public DaoObservable() // Constructor
    {
        this.observadores = new ArrayList<IObservadorDeDao>(); // inicializa con una lista vacia y puede contener tipos de datos IbservadorDeDao
    }

    public void agregarObservador(IObservadorDeDao observador) //Recibe el tipo de dato IobservadorDeDao y lo agrega a la lista // Mi bussiness object es cuenta
    {
        this.observadores.add(observador);
    }

    public void notificarBaja(String codigo) {
        for (IObservadorDeDao object : this.observadores) {
            object.bajaEnDao(codigo);
        }
    }

    public void notificarAlta(Cuenta cuenta) {
        for (IObservadorDeDao object : this.observadores) {
            object.altaEnDao(cuenta);
        }
    }

    public void notificarModificacion(Cuenta cuenta) {
        for (IObservadorDeDao object : this.observadores) {
            object.modificacionEnDao(cuenta);
        }
    }
}
