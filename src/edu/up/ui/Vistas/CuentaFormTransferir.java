package edu.up.ui.Vistas;

import edu.up.Entidades.Cuenta;
import edu.up.ui.ControlesVisuales.ControlFloat;
import edu.up.ui.ControlesVisuales.ControlInteger;
import edu.up.ui.ControlesVisuales.ControlTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CuentaFormTransferir extends Form
{
    private ControlTexto controlNombre; // nuevo
    private ControlFloat controlSaldoDisponible; // nuevo

    public ControlTexto getControlNombre() {
        return controlNombre;
    } // nuevo
    public ControlFloat getControlSaldo() {
        return controlSaldoDisponible;
    } // nuevo

    private Cuenta datosParaTransferir;  // nuevo
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

    public void RefrescarDatosUsuario(int dni)
    {
        this.cuentas.clear();
        this.cuentas.addAll( this.handler.listarCuentasPorDni(dni) );
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
        //======================================================================================================//
        //=================================== DEFINO EL CONTAINER TRANSFERIR=================================== //
        //======================================================================================================//
        Container transferir = new JPanel();
        transferir.setSize(400, 100);
        transferir.setLayout(new BoxLayout(transferir, BoxLayout.X_AXIS));
        //transferir.add(Box.createVerticalStrut(10));
        //transferir.add(Box.createHorizontalStrut(10));
        //transferir.add(Box.createVerticalStrut(10));
        //transferir.add(Box.createHorizontalStrut(10));


        //this.controlSaldoDisponible = new ControlFloat("Ingrese monto a transferir");
        //this.add(this.controlSaldoDisponible);

        Container destino = new JPanel();
        destino.setSize(200,100);
        destino.setLayout(new BoxLayout(destino, BoxLayout.LINE_AXIS));

        JLabel labelparadestino = new JLabel("Ingrese cuenta destino       ");
        JTextField cuentaDestinoEscrita = new JTextField();
        cuentaDestinoEscrita.setMinimumSize(new Dimension(100,50));
        cuentaDestinoEscrita.setMaximumSize(new Dimension(200,400));
        destino.add(labelparadestino);
        destino.add(cuentaDestinoEscrita);

        Container montoATransferir = new JPanel();
        montoATransferir.setSize(200,100);
        montoATransferir.setLayout(new BoxLayout(montoATransferir, BoxLayout.LINE_AXIS));

        JLabel labelparamonto = new JLabel("Ingrese monto a Transferir");
        JTextField montoEscrito = new JTextField();
        montoEscrito.setMinimumSize(new Dimension(100,50));
        montoEscrito.setMaximumSize(new Dimension(200,400));
        montoATransferir.add(labelparamonto);
        montoATransferir.add(montoEscrito);


        JButton botontransferir = new JButton("Transferir");


        botontransferir.addActionListener(new ActionListener()
        {
            @Override    //CLAVADISIMO ACA CON LA TRANSFERENCIA
            public void actionPerformed (ActionEvent e)
            {
                int cuentaOrigen = grilla.getSelectedRow();
               //float montoATransferir = datosParaTransferir.getSaldo();
                //int cuentaDestino = 21323;
               // int cuentaDestino =
                if ( cuentaOrigen >= 0 ) {
                // handler.transferenciaCuentas(cuentas.get(cuentaOrigen), cuentaDestino, 0));
                }
            }
        });



        this.add(listar);
        this.add(Box.createHorizontalStrut(10));
        //montoATransferir.add(Box.createVerticalStrut(10));
        //montoATransferir.add(Box.createHorizontalStrut(10));
        //destino.add(Box.createVerticalStrut(10));
        //destino.add(Box.createHorizontalStrut(10));
        this.add(Box.createHorizontalStrut(10));
        this.add(montoATransferir);
        this.add(destino);
        this.add(botontransferir);
    }
    // </editor-fold>
}