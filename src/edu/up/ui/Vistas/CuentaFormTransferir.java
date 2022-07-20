package edu.up.ui.Vistas;

import edu.up.Entidades.Cuenta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CuentaFormTransferir extends Form
{
    private List<Cuenta> cuentas;

    public CuentaFormTransferir(HandlerAplicacion handler)
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
        return "¿Desde que cuenta desea transferir?";
    }

    @Override
    protected void dibujarFormulario()
    {
        this.cuentas = this.handler.listarCuentas();
        JTable grilla = new JTable( new ModeloCuentas( this.cuentas ) );

        JScrollPane listar = new JScrollPane(grilla);
        listar.setMaximumSize(new Dimension(800, 600));

        Container transferir = new JPanel();

        transferir.setSize(800, 100);
        transferir.setLayout(new BoxLayout(transferir, BoxLayout.X_AXIS));

        transferir.add(Box.createVerticalStrut(10));
        transferir.add(Box.createHorizontalStrut(10));

        JButton botontransferir = new JButton("Transferir");
        botontransferir.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                handler.transferencia( cuentas.get( grilla.getSelectedRow() ) );
            }
        });
        transferir.add(botontransferir);
        transferir.add(Box.createHorizontalStrut(10));

        transferir.add(Box.createHorizontalStrut(10));

        transferir.add(Box.createVerticalStrut(10));

        this.add(listar);

        this.add(transferir);
    }
    // </editor-fold>
}