package edu.up.ui.Vistas;

import edu.up.Entidades.Cuenta;
import edu.up.Excepciones.ExcepcionCuenta;
import edu.up.Mensajeria;
import edu.up.Negocio.CuentaBO;
import edu.up.Negocio.IObservadorDeBussinessObject;
import edu.up.ServicioErrores;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

public class HandlerAplicacion implements IObservadorDeBussinessObject
{
    protected final MenuPrincipal formulario;
    protected final CuentaBO negocio;
    
    protected CuentaFormABM panelABMCuenta;
    protected CuentaFormListar panelListarCuenta;
            
    public HandlerAplicacion( MenuPrincipal formulario )
    {
        this.negocio = new CuentaBO();
        this.negocio.agregarObservador( this );
        this.formulario = formulario;
        
        this.panelABMCuenta = this.createCuentaPanel();
        this.panelListarCuenta = this.createListarCuentasPanel();
    }
        
    private void ActivarPanel( JPanel panel )
    {
        this.formulario.setContentPane( panel );
        this.formulario.revalidate();
        this.formulario.repaint();
    }

    // <editor-fold defaultstate="collapsed" desc="Manejo de eventos del menu">
    public void activarPanelCrearCuenta( ActionEvent e )  
    {
        this.panelABMCuenta.setearEntidad( new Cuenta( "", 0, "", "", 0 )  );
        this.ActivarPanel( this.panelABMCuenta );
    }

    public void activarPanelListarCuenta( ActionEvent e )
    {
        this.panelListarCuenta.RefrescarDatos();
        this.ActivarPanel(this.panelListarCuenta );
    }

    private CuentaFormABM createCuentaPanel()
    {
        return new CuentaFormABM( this );
    }

    private CuentaFormListar createListarCuentasPanel()
    {
        return new CuentaFormListar( this );
    }
    
    public void modificarCuenta(  ActionEvent e, Cuenta cuenta )
    {
        this.panelABMCuenta.setearEntidad( cuenta );
        
        this.ActivarPanel( this.panelABMCuenta );
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Manejo de eventos de Listar cuentas">
    public void grabar( Cuenta cuenta )
    {
        try
        {
            negocio.grabar( cuenta );
        }
        catch ( ExcepcionCuenta ex )
        {
            ServicioErrores.getInstancia().informarError( ex );
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Manejo de eventos del ABM de cuentas">
    public List<Cuenta> listarCuentas()
    {
        List<Cuenta> retorno = new LinkedList<>();

        try
        {
            retorno = this.negocio.listarCuentas();
        }
        catch ( ExcepcionCuenta ex )
        {
            ServicioErrores.getInstancia().informarError( ex );
        }
        
        return retorno;
    }
    
    public void eliminarCuenta( Cuenta seleccionEliminar )
    {
        try
        {
            this.negocio.eliminarCuenta( seleccionEliminar );
        }
        catch ( ExcepcionCuenta ex )
        {
            ServicioErrores.getInstancia().informarError( ex );
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Interfaz IObservadorDeBussinessObject">
    public void baja( String codigo )
    {
        //Mensajeria.getInstancia().MostrarInformacion( "Baja" + codigo  );
        this.panelListarCuenta.actualizarListaPorCodigoEliminado( codigo );
        this.panelListarCuenta.repaint();
    }

    public void alta( Cuenta cuenta )
    {
        Mensajeria.getInstancia().MostrarInformacion( "Se ha creado la cuenta" );
        this.activarPanelListarCuenta( null );
    }

    public void modificacion( Cuenta cuenta )
    {
        Mensajeria.getInstancia().MostrarInformacion( "Se ha modificado la cuenta " + cuenta  );
        this.activarPanelListarCuenta( null );
        this.panelListarCuenta.RefrescarDatos();
        this.panelListarCuenta.repaint();
    }
    // </editor-fold>
}
