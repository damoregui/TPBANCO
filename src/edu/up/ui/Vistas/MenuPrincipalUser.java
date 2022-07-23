package edu.up.ui.Vistas;

import edu.up.Excepciones.DatoInvalidoException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalUser extends JFrame
{
    private HandlerAplicacion handler;

    private int dni;
    private int cuentaDestino;
    private int cuentaOrigen;

    public MenuPrincipalUser() throws HeadlessException
    {
        super( "Sistema Bancario / VISTA DE USUARIO" );

        this.handler = new HandlerAplicacion( this);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setJMenuBar(createMenu());
    }

    public void mostrar() throws DatoInvalidoException {
        String s = JOptionPane.showInputDialog(
                this,
                "Ingrese DNI",
                "Ingrese DNI",
                JOptionPane.PLAIN_MESSAGE
                );
        if ((s != null) && (s.trim().length() > 0)) {
            try {
                this.dni = Integer.parseInt(s.trim());
            } catch (Exception ex) {
                throw new DatoInvalidoException("El DNI es incorrecto: " + s, ex);
            }
        } else {
            throw new DatoInvalidoException("El DNI es incorrecto");
        }

        this.setVisible(true);
    }

    public void ocultar()
    {
        this.setVisible(false);
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
                handler.activarPanelListarCuentaUsuario( e , dni);
            }
        });
        menuCuentas.add(listarCuentas);
// -----------------------------------------------------------------------------------------------------------//
// -------------------------------- USER: Transferir a otra cuenta--------------------------------------------//
// -----------------------------------------------------------------------------------------------------------//
        JMenuItem transferirEntreCuentas = new JMenuItem("Transferir");
        transferirEntreCuentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {handler.activarPanelTransferirCuenta( e, dni);
            }

        }

        );

        menuCuentas.add(transferirEntreCuentas);

// -----------------------------------------------------------------------------------------------------------//
// -------------------------------- USER: listar tarjetas ----------------------------------------------------//
// -----------------------------------------------------------------------------------------------------------//

        JMenuItem listarTarjeta = new JMenuItem("Listar Tarjetas");
        listarTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handler.activarPanelListarTarjetaUsuario( e , dni);
            }
        });
        menuTarjetas.add(listarTarjeta);

//-----------------------------------------------------------------------------------------------------------//
//-----------------------Le indico al menuBar que me agregue las opciones de cuentas, tarjetas y trf --------//
//-----------------------------------------------------------------------------------------------------------//
        menuBar.add(menuVistaUsuario);
        menuBar.add(menuCuentas);
        menuBar.add(menuTarjetas);
        return menuBar;
    }

}