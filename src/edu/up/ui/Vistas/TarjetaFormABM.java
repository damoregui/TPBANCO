package edu.up.ui.Vistas;

import edu.up.Entidades.Tarjeta;
import edu.up.Excepciones.ExcepcionTarjeta;
import edu.up.ServicioErrores;
import edu.up.ui.ControlesVisuales.ControlFloat;
import edu.up.ui.ControlesVisuales.ControlInteger;
import edu.up.ui.ControlesVisuales.ControlTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TarjetaFormABM extends Form
{
    // <editor-fold defaultstate="collapsed" desc="Propiedades">
    private ControlInteger controlDniPropietario;
    private ControlFloat controlSaldoTarjeta;
    private ControlFloat controlLimite;

    public ControlInteger getControlDni()
    {
        return controlDniPropietario;
    }

    public ControlFloat getControlSaldoTarjeta()
    {
        return controlSaldoTarjeta;
    }

    public ControlFloat getControlLimite()
    {
        return controlLimite;
    }


    private Tarjeta entidadTarjeta;
    // </editor-fold>

    public TarjetaFormABM(HandlerAplicacion handler )
    {
        super( handler );
    }

    public void setearEntidadTarjeta( Tarjeta entidadTarjeta )
    {
        this.entidadTarjeta = entidadTarjeta;
        this.controlDniPropietario.setValor( this.entidadTarjeta.getDniPropietario() );
        this.controlSaldoTarjeta.setValor( this.entidadTarjeta.getSaldoTarjeta() );
        this.controlLimite.setValor( this.entidadTarjeta.getLimite() );
    }

    // <editor-fold defaultstate="collapsed" desc="Implementacion de Form">
    @Override
    protected String obtenerTitulo()
    {
        return "Tarjeta";
    }

    @Override
    protected void dibujarFormulario()
    {
        this.controlDniPropietario = new ControlInteger( "DNI" );
        this.add( this.controlDniPropietario );

        this.controlSaldoTarjeta = new ControlFloat( "Saldo de la tarjeta:" );
        this.add( this.controlSaldoTarjeta );

        this.controlLimite = new ControlFloat( "Limite de la tarjeta" );
        this.add( this.controlLimite );

        // Agregar botonera
        Container panelbotonera = new JPanel();

        panelbotonera.setSize(800, 100);
        panelbotonera.setLayout(new BoxLayout(panelbotonera, BoxLayout.X_AXIS));

        panelbotonera.add(Box.createVerticalStrut(10));
        panelbotonera.add(Box.createHorizontalStrut(10));

        JButton botonok = new JButton("Ok");
        panelbotonera.add(botonok);
        panelbotonera.add(Box.createHorizontalStrut(10));


        JButton botoncancelar = new JButton("Cancelar");
        panelbotonera.add(botoncancelar);
        panelbotonera.add(Box.createHorizontalStrut(10));
        panelbotonera.add(Box.createVerticalStrut(10));

        // action listener para los textfields

        botonok.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Excepcion de DNI Propietario tarjeta //--------------------------------------------------------------------------------
                try
                {
                    entidadTarjeta.setDniPropietario( controlDniPropietario.getValorTarjeta() );
                    if (controlDniPropietario.getValorTarjeta() < 1){
                        throw new ExcepcionTarjeta("El dni es invalido por ser menor a 1", null);
                    }
                }
                catch ( ExcepcionTarjeta ex )
                {
                    ServicioErrores.getInstancia().informarError(ex, "Error en la carga del campo dni :" );
                    return;
                }
                // Excepcion de SALDO //
                try {
                    entidadTarjeta.setSaldoTarjeta(controlSaldoTarjeta.getValorTarjeta());
                    if (controlSaldoTarjeta.getValorTarjeta() < 0) {
                        throw new ExcepcionTarjeta("El valor inicial del saldo no puede ser menor a 0 (cero)", null);
                    }
                } catch (ExcepcionTarjeta excepcionTarjeta) {
                    ServicioErrores.getInstancia().informarError(excepcionTarjeta, "El valor para el saldo es inválido");
                    return;
                }
                try {
                    entidadTarjeta.setLimite(controlLimite.getValorTarjeta());
                    if (controlLimite.getValorTarjeta() < 0) {
                        throw new ExcepcionTarjeta("El Limite inicial de la tarjeta no puede ser menor a 0 (cero)", null);
                    }
                } catch (ExcepcionTarjeta excepcionTarjeta) {
                    ServicioErrores.getInstancia().informarError(excepcionTarjeta, "El valor para el saldo es inválido");
                    return;
                }

                handler.grabarTarjeta(entidadTarjeta);
            }

        });
        this.add(panelbotonera);
    }

    ;


}
// </editor-fold>


