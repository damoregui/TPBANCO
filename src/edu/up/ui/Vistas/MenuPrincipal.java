package edu.up.ui.Vistas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuPrincipal extends JFrame
{
    private HandlerAplicacion handler;

    public MenuPrincipal() throws HeadlessException
    {
        super( "Sistema Bancario / VISTA DE EMPLEADO" );

        this.handler = new HandlerAplicacion( this );

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setJMenuBar(createMenu()); //Para mostrar el menu bar por que antes no mostraba nada

    }

    public void mostrar()
    {
        this.setVisible(true);
    }

    public void ocultar() {
        this.setVisible(false);
    }
    private JMenuBar createMenu()
    {
        JMenuBar menuBar = new JMenuBar();


        JMenu menuVistaUsuario = new JMenu("Cambiar a modo usuario");
        JMenu menuCuentas = new JMenu("Cuenta");
        JMenu menuTarjetas = new JMenu("Tarjetas");

        JMenuItem cambiarVista = new JMenuItem("Cambiar vista a modo usuario");
        cambiarVista.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent e) {
                                              handler.activarPanelVistaUsuario( e );
                                          }
                                      }
        );
        menuVistaUsuario.add(cambiarVista);
// -----------------------------------------------------------------------------------------------------------//
// --------------------------------  crear cuenta ------------------------------------------------------------//
// -----------------------------------------------------------------------------------------------------------//
        JMenuItem crearCuenta = new JMenuItem("Crear");
        crearCuenta.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent e) {
                                              handler.activarPanelCrearCuenta( e );
                                          }
                                      }
        );
        menuCuentas.add(crearCuenta);
// -----------------------------------------------------------------------------------------------------------//
// --------------------------------  listar cuenta ------------------------------------------------------------//
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
// --------------------------------  Transferir entre cuentas ------------------------------------------------//
// -----------------------------------------------------------------------------------------------------------//
        JMenuItem transferirEntreCuentas = new JMenuItem("Transferir");
        transferirEntreCuentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {handler.activarPanelTransferirCuenta( e );
            }
        });
        menuCuentas.add(transferirEntreCuentas);

// -----------------------------------------------------------------------------------------------------------//
// --------------------------------  crear tarjetas ------------------------------------------------------------//
// -----------------------------------------------------------------------------------------------------------//

        JMenuItem crearTarjeta = new JMenuItem("Crear");
        crearTarjeta.addActionListener(new ActionListener() {
                                           @Override
                                           public void actionPerformed(ActionEvent e) {
                                               handler.activarPanelCrearTarjeta( e );
                                           }
                                       }
        );
        menuTarjetas.add(crearTarjeta);
// -----------------------------------------------------------------------------------------------------------//
// --------------------------------  listar tarjetas  ------------------------------------------------------------//
// -----------------------------------------------------------------------------------------------------------//
        JMenuItem listarTarjeta = new JMenuItem("Listar");
        listarTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handler.activarPanelListarTarjeta( e );
            }
        });
        menuTarjetas.add(listarTarjeta);

//------------------------------------------------------------------------------------------------------------
//-----------------------Le indico al menuBar que me agregue las opciones de cuentas, tarjetas y trf --------------//
// -----------------------------------------------------------------------------------------------------------//


        menuBar.add(menuVistaUsuario);
        menuBar.add(menuCuentas);
        menuBar.add(menuTarjetas);

        return menuBar;
    }

}