package edu.up.ui.Vistas;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

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
    
    private JMenuBar createMenu()
    {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuCuentas = new JMenu("Cuenta");
        JMenu menuTarjetas = new JMenu("Tarjetas");
        JMenu menuTransferencias = new JMenu("Transferencias");

// -------------------------------- Agregar crear y Listar a la cuenta ---------------------------------------
        JMenuItem crearCuenta = new JMenuItem("Crear");
        crearCuenta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handler.activarPanelCrearCuenta( e );
                }
            }
        );
        menuCuentas.add(crearCuenta);

        JMenuItem listarCuentas = new JMenuItem("Listar");
        listarCuentas.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handler.activarPanelListarCuenta( e );
                }
        });
        menuCuentas.add(listarCuentas);

        JMenuItem transferirEntreCuentas = new JMenuItem("Transferir");
        transferirEntreCuentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handler.activarPanelListarCuenta( e );
            }
        });
        menuCuentas.add(transferirEntreCuentas);

// -------------------------------- Agregar crear y Listar Tarjetas ---------------------------------------

        JMenuItem crearTarjeta = new JMenuItem("Crear");
        crearTarjeta.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent e) {
                                              handler.activarPanelCrearTarjeta( e );
                                          }
                                      }
        );
        menuTarjetas.add(crearTarjeta);

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
        menuBar.add(menuCuentas);
        menuBar.add(menuTarjetas); // todavía no está activa
        return menuBar; //devolveme el menuBar al que le acabo de agregar las opciones
    }

}