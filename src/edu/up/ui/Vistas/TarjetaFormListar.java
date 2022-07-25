package edu.up.ui.Vistas;

import edu.up.Entidades.Tarjeta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TarjetaFormListar extends Form
{
    private List<Tarjeta> tarjetas;

    public TarjetaFormListar(HandlerAplicacion handler)
    {
        super(handler);
    }

    public void RefrescarDatos()
    {
        this.tarjetas.clear();
        this.tarjetas.addAll( this.handler.listarTarjetas() );
    }

    public void RefrescarDatosUsuario(int dni)
    {
        this.tarjetas.clear();
        this.tarjetas.addAll( this.handler.listarTarjetasPorDni(dni));
    }

    // <editor-fold defaultstate="collapsed" desc="Implementacion de Form">
    @Override
    protected String obtenerTitulo()
    {
        return "Tarjetas";
    }

    @Override
    protected void dibujarFormulario()
    {
        this.tarjetas = this.handler.listarTarjetas();
        JTable grilla = new JTable( new ModeloTarjetas( this.tarjetas ) );

        JScrollPane listar = new JScrollPane(grilla);
        listar.setMaximumSize(new Dimension(800, 600));

        Container modificareliminar = new JPanel();

        modificareliminar.setSize(800, 100);
        modificareliminar.setLayout(new BoxLayout(modificareliminar, BoxLayout.X_AXIS));

        modificareliminar.add(Box.createVerticalStrut(10));
        modificareliminar.add(Box.createHorizontalStrut(10));

        modificareliminar.add(Box.createHorizontalStrut(10));

        JButton botoneliminar = new JButton("Eliminar");
        botoneliminar.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                int seleccionado = grilla.getSelectedRow();
                if ( seleccionado >= 0 )
                {
                    handler.eliminarTarjeta(tarjetas.get( seleccionado ) );
                }
            }
        });
        modificareliminar.add(botoneliminar);
        
        modificareliminar.add(Box.createHorizontalStrut(10));

        modificareliminar.add(Box.createVerticalStrut(10));

        this.add(listar);

        this.add(modificareliminar);
    }
    // </editor-fold>
}