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
        this.setJMenuBar(createMenu());
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

        menuBar.add(menuCuentas);

        return menuBar;
    }

}