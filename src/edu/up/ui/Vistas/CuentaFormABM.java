package edu.up.ui.Vistas;

import edu.up.Entidades.Cuenta;
import edu.up.Excepciones.ExcepcionCuenta;
import edu.up.ServicioErrores;
import edu.up.ui.ControlesVisuales.ControlFloat;
import edu.up.ui.ControlesVisuales.ControlInteger;
import edu.up.ui.ControlesVisuales.ControlTexto;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
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

        this.controlTipoCta = new ControlTexto( "Tipo de cuenta (CC / CA / CD)" );
        this.add( this.controlTipoCta );

        this.controlSaldo = new ControlFloat( "Saldo" );
        this.add( this.controlSaldo );

        // Agregar botonera
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
                // excepcion de nombre // ----------------------------------------------------------------------------
                try{
                    entidad.setNombreCompleto( controlNombre.getValor() );
                } catch (ExcepcionCuenta excepcion){
                    ServicioErrores.getInstancia().informarError(excepcion, "Error en la carga del campo NOMBRE");
                    return;
                }
                // Excepcion de DNI //--------------------------------------------------------------------------------
                try
                {
                    entidad.setDni( controlDni.getValor() );
                    if (controlDni.getValor() < 1){
                        throw new ExcepcionCuenta("El dni es invalido por ser menor a 1", null);
                    }
                }
                catch ( ExcepcionCuenta ex )
                {
                    ServicioErrores.getInstancia().informarError(ex, "Error en la carga del campo dni :" );
                    return;
                }
                // Excepcion de Tipo cuenta //-----------------------------------------------------------------------
                try {
                    ArrayList<String> valoresArray = new ArrayList(3);
                    valoresArray.add("CA");
                    valoresArray.add("CC");
                    valoresArray.add("CD");
                    entidad.setTipoCuenta(controlTipoCta.getValor());
                    //if (!(controlTipoCta.getValor()).equals(valoresArray.contains(0)))
                    if (!valoresArray.contains((controlTipoCta.getValor().toUpperCase())))
                            throw new ExcepcionCuenta("ESTE CAMPO SOLO ADMITE LOS VALORES:\n ´CA´ / ´CC´ / ´CD´. Modifiquelo por favor", null);
                    }
                catch (ExcepcionCuenta excepcionCuenta) {
                    ServicioErrores.getInstancia().informarError(excepcionCuenta, "Error en la carga del tipo de cuenta \n");
                    return;
                }
                // Excepcion de SALDO //
                try {
                    entidad.setSaldo(controlSaldo.getValor());
                    if (controlSaldo.getValor() < 0) {
                        throw new ExcepcionCuenta("El valor inicial del saldo no puede ser menor a 0 (cero)", null);
                    }
                } catch (ExcepcionCuenta excepcionCuenta) {
                    ServicioErrores.getInstancia().informarError(excepcionCuenta, "El valor para el saldo es inválido");
                    return;
                }

                handler.grabar(entidad);
            }

        });
        this.add(panelbotonera);
    }

    ;


}
// </editor-fold>


