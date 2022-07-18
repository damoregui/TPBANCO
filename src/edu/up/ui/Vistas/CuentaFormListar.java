package edu.up.ui.Vistas;

import edu.up.Entidades.Cuenta;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CuentaFormListar extends Form
{
    private List<Cuenta> cuentas;
    
    public CuentaFormListar(HandlerAplicacion handler)
    {
        super(handler);
    }

    public void RefrescarDatos()
    {
        this.cuentas.clear();
        this.cuentas.addAll( this.handler.listarCuentas() );
    }
    
    public void actualizarListaPorCodigoEliminado( String codigo )
    {
        this.cuentas.removeIf( x-> x.getCodigo() == codigo );
    }
    
    // <editor-fold defaultstate="collapsed" desc="Implementacion de Form">
    @Override
    protected String obtenerTitulo()
    {
        return "Cuentas";
    }

    @Override
    protected void dibujarFormulario()
    {
        this.cuentas = this.handler.listarCuentas();
        JTable grilla = new JTable( new ModeloCuentas( this.cuentas ) );

        JScrollPane listar = new JScrollPane(grilla);
        listar.setMaximumSize(new Dimension(800, 600));

        Container modificareliminar = new JPanel();

        modificareliminar.setSize(800, 100);
        modificareliminar.setLayout(new BoxLayout(modificareliminar, BoxLayout.X_AXIS));

        modificareliminar.add(Box.createVerticalStrut(10));
        modificareliminar.add(Box.createHorizontalStrut(10));

        JButton botonmodificar = new JButton("Modificar");
        botonmodificar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                handler.modificarCuenta( e, cuentas.get( grilla.getSelectedRow() ) );
            }
        });
        modificareliminar.add(botonmodificar);
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
                    handler.eliminarCuenta( cuentas.get( seleccionado ) );
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