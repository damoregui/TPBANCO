package edu.up.ui.Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalUser extends JFrame
{
    private HandlerAplicacion handler;

    public MenuPrincipalUser() throws HeadlessException
    {
        super( "Sistema Bancario / VISTA DE USUARIO" );

        this.handler = new HandlerAplicacion( this);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setJMenuBar(createMenu());
    }

    public void mostrar()
    {
        this.setVisible(true);
    }

    private JMenuBar createMenu()
    {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuVistaUsuario = new JMenu("Cambiar a modo ADMIN");
        JMenu menuCuentas = new JMenu("Cuenta");
        JMenu menuTarjetas = new JMenu("Tarjetas");

        JMenuItem cambiarVista = new JMenuItem("Cambiar vista a modo admin");
        cambiarVista.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent e) {
                                              handler.activarPanelAdmin( e );
                                          }
                                      });
        menuVistaUsuario.add(cambiarVista);

// -----------------------------------------------------------------------------------------------------------//
// -------------------------------- USER:  Listar Cuentas ----------------------------------------------------//
// -----------------------------------------------------------------------------------------------------------//
        JMenuItem listarCuentas = new JMenuItem("Listar");
        listarCuentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handler.activarPanelListarCuenta( e );
            }
        });
        menuCuentas.add(listarCuentas);
// -----------------------------------------------------------------------------------------------------------//
// -------------------------------- USER: Transferir a otra cuenta--------------------------------------------//
// -----------------------------------------------------------------------------------------------------------//
        JMenuItem transferirEntreCuentas = new JMenuItem("Transferir");
        transferirEntreCuentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {handler.activarPanelTransferirCuenta( e );
            }
        });
        menuCuentas.add(transferirEntreCuentas);

// -----------------------------------------------------------------------------------------------------------//
// -------------------------------- USER: listar tarjetas ----------------------------------------------------//
// -----------------------------------------------------------------------------------------------------------//

        JMenuItem listarTarjeta = new JMenuItem("Listar");
        listarTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handler.activarPanelListarTarjeta( e );
            }
        });
        menuTarjetas.add(listarTarjeta);

        JPanel completardni = new JPanel(Boolean.parseBoolean("Ingresar DNI"));
        menuBar.add(completardni);

//-----------------------------------------------------------------------------------------------------------//
//-----------------------Le indico al menuBar que me agregue las opciones de cuentas, tarjetas y trf --------//
//-----------------------------------------------------------------------------------------------------------//
        menuBar.add(menuVistaUsuario);
        menuBar.add(menuCuentas);
        menuBar.add(menuTarjetas);
        return menuBar;
    }

}