package edu.up.ui.Vistas;

import edu.up.Entidades.Cuenta;
import edu.up.ui.ControlesVisuales.ControlFloat;
import edu.up.ui.ControlesVisuales.ControlInteger;
import edu.up.ui.ControlesVisuales.ControlTexto;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CuentaFormABM extends Form
{
    // <editor-fold defaultstate="collapsed" desc="Propiedades">        
    private ControlTexto controlNombre;
    private ControlInteger controlDni;
    private ControlFloat controlSaldo;
    private ControlTexto controlTipoCta;

    public ControlTexto getControlNombre()
    {
        return controlNombre;
    }
    
    public ControlInteger getControlDni()
    {
        return controlDni;
    }
    
    public ControlFloat getControlSaldo()
    {
        return controlSaldo;
    }
    
    public ControlTexto getControlTipoCta()
    {
        return controlTipoCta;
    }
    
    private Cuenta entidad;
    // </editor-fold>

    public CuentaFormABM( HandlerAplicacion handler )
    {
        super( handler );
    }    
    
    public void setearEntidad( Cuenta entidad )
    {
        this.entidad = entidad;
        
        this.controlDni.setValor( this.entidad.getDni() );
        this.controlNombre.setValor( this.entidad.getNombre() );
        this.controlTipoCta.setValor( this.entidad.getTipoCuenta() );
        this.controlSaldo.setValor( this.entidad.getSaldo() );
    }
    
    // <editor-fold defaultstate="collapsed" desc="Implementacion de Form">
    @Override
    protected String obtenerTitulo()
    {
        return "Cuenta";
    }

    @Override
    protected void dibujarFormulario()
    {
        this.controlNombre = new ControlTexto( "Nombre" );
        this.add( this.controlNombre );
        
        this.controlDni = new ControlInteger( "DNI" );
        this.add( this.controlDni );
        
        this.controlTipoCta = new ControlTexto( "Tipo de cuenta" );
        this.add( this.controlTipoCta );
        
        this.controlSaldo = new ControlFloat( "Saldo" );
        this.add( this.controlSaldo );

        // botonera ok cancelar
        Container panelbotonera = new JPanel();

        panelbotonera.setSize(800, 100);
        panelbotonera.setLayout(new BoxLayout(panelbotonera, BoxLayout.X_AXIS));

        panelbotonera.add(Box.createVerticalStrut(10));
        panelbotonera.add(Box.createHorizontalStrut(10));
        
        JButton botonok = new JButton("Ok");
        panelbotonera.add(botonok);
        panelbotonera.add(Box.createHorizontalStrut(10));
        
        JButton botoncancelar = new JButton("Cancelar");
        panelbotonera.add(botoncancelar);
        panelbotonera.add(Box.createHorizontalStrut(10));
        panelbotonera.add(Box.createVerticalStrut(10));

        // action listener para los textfields
        
        botonok.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                entidad.setNombreCompleto( controlNombre.getValor() );
                entidad.setDni( controlDni.getValor() );
                entidad.setTipoCuenta( controlTipoCta.getValor() );
                entidad.setSaldo( controlSaldo.getValor() );

                handler.grabar( entidad );
            }
        });

        this.add(panelbotonera);}
    // </editor-fold>
}
