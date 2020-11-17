package edu.up.ui.Vistas;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Form extends JPanel
{
    protected HandlerAplicacion handler;

    public Form( HandlerAplicacion handler )
    {
        this.handler = handler;

        this.setSize(800, 600);
        this.setLayout(new BoxLayout( this, BoxLayout.Y_AXIS));
        this.add( new JLabel( this.obtenerTitulo() ) );
        this.dibujarFormulario();
    }

    protected abstract String obtenerTitulo();
    protected abstract void dibujarFormulario();
}
