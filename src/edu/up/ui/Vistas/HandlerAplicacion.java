package edu.up.ui.Vistas;

import edu.up.Entidades.Cuenta;
import edu.up.Entidades.Tarjeta;
import edu.up.Excepciones.ExcepcionTarjeta;
import edu.up.Excepciones.ExcepcionCuenta;
import edu.up.Mensajeria;
import edu.up.Negocio.CuentaBO;
import edu.up.Negocio.IObservadorDeBussinessObject;
import edu.up.Negocio.IObservadorDeBussinessObjectTarjeta;
import edu.up.Negocio.TarjetaBO;
import edu.up.ServicioErrores;

import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

public class HandlerAplicacion implements IObservadorDeBussinessObject, IObservadorDeBussinessObjectTarjeta {
    private final MenuPrincipal formulario;
    private final CuentaBO negocio;

    private final TarjetaBO negocioTarjeta;
    private CuentaFormABM panelABMCuenta;
    private CuentaFormListar panelListarCuenta;

    private TarjetaFormABM panelABMTarjeta;
    private TarjetaFormListar panelListarTarjeta;

    public HandlerAplicacion(MenuPrincipal formulario) {
        this.negocio = new CuentaBO();
        this.negocio.agregarObservador(this);

        this.negocioTarjeta = new TarjetaBO();
        this.negocioTarjeta.agregarObservador(this);

        this.formulario = formulario;

        this.panelABMCuenta = this.createCuentaPanel();
        this.panelListarCuenta = this.createListarCuentasPanel();

        this.panelABMTarjeta = this.createTarjetaPanel();
        this.panelListarTarjeta = this.createListarTarjetasPanel();
    }

    private void ActivarPanel(JPanel panel) {
        this.formulario.setContentPane(panel);
        this.formulario.revalidate();
        this.formulario.repaint();
    }

    // <editor-fold defaultstate="collapsed" desc="Manejo de eventos del menu">
    public void activarPanelCrearCuenta(ActionEvent e) {
        this.panelABMCuenta.setearEntidad(new Cuenta("", 0, "", "", 0));
        this.ActivarPanel(this.panelABMCuenta);
    }

    public void activarPanelListarCuenta(ActionEvent e) {
        this.panelListarCuenta.RefrescarDatos();
        this.ActivarPanel(this.panelListarCuenta);
    }
    public void activarPanelCrearTarjeta(ActionEvent e) {
        this.panelABMTarjeta.setearEntidadTarjeta(new Tarjeta(0, 0, 0));
        this.ActivarPanel(this.panelABMTarjeta);
    }
    public void activarPanelListarTarjeta(ActionEvent e) {
        this.panelListarTarjeta.RefrescarDatos();
        this.ActivarPanel(this.panelListarTarjeta);
    }

    private CuentaFormABM createCuentaPanel() {
        return new CuentaFormABM(this);
    }

    private TarjetaFormABM createTarjetaPanel() {
        return new TarjetaFormABM(this);
    }

    private CuentaFormListar createListarCuentasPanel() {
        return new CuentaFormListar(this);
    }

    private TarjetaFormListar createListarTarjetasPanel() {
        return new TarjetaFormListar(this);
    }


    public void modificarCuenta(ActionEvent e, Cuenta cuenta) {
        this.panelABMCuenta.setearEntidad(cuenta);
        this.ActivarPanel(this.panelABMCuenta);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Manejo de eventos de Listar cuentas">
    public void grabar(Cuenta cuenta) {
        try {
            negocio.grabar(cuenta);
        } catch (ExcepcionCuenta ex) {
            ServicioErrores.getInstancia().informarError(ex);
        }
    }

    //EL GRABAR TARJETA TIENE QUE SER Tarjeta tarjeta y devolver tarjeta en el grabar
    public void grabarTarjeta(Tarjeta tarjeta) {
        try {
            negocioTarjeta.grabarTarjeta(tarjeta);
        } catch (ExcepcionTarjeta ex) {
            ServicioErrores.getInstancia().informarError(ex);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Manejo de eventos del ABM de cuentas">
    public List<Cuenta> listarCuentas() {
        List<Cuenta> retorno = new LinkedList<>();

        try {
            retorno = this.negocio.listarCuentas();
        } catch (ExcepcionCuenta ex) {
            ServicioErrores.getInstancia().informarError(ex);
        }

        return retorno;
    }

    public List<Tarjeta> listarTarjetas() {
        List<Tarjeta> retorno = new LinkedList<>();

        try {
            retorno = this.negocioTarjeta.listarTarjetas();
        } catch (ExcepcionTarjeta ex) {
            ServicioErrores.getInstancia().informarError(ex);
        }

        return retorno;
    }

    public void eliminarCuenta(Cuenta seleccionEliminar) {
        try {
            this.negocio.eliminarCuenta(seleccionEliminar);
        } catch (ExcepcionCuenta ex) {
            ServicioErrores.getInstancia().informarError(ex);
        }
    }

    public void eliminarTarjeta(Tarjeta seleccionEliminar) {
        try {
            this.negocioTarjeta.eliminarTarjeta(seleccionEliminar);
        } catch (ExcepcionTarjeta ex) {
            ServicioErrores.getInstancia().informarError(ex);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Interfaz IObservadorDeBussinessObject">
    public void baja(String codigo) {
        //Mensajeria.getInstancia().MostrarInformacion( "Baja" + codigo  );
        this.panelListarCuenta.actualizarListaPorCodigoEliminado(codigo);
        this.panelListarCuenta.repaint();
    }

    public void alta(Cuenta cuenta) {
        Mensajeria.getInstancia().MostrarInformacion("Se ha creado la cuenta");
        this.activarPanelListarCuenta(null);
    }

    public void modificacion(Cuenta cuenta) {
        Mensajeria.getInstancia().MostrarInformacion("Se ha modificado la cuenta " + cuenta);
        this.activarPanelListarCuenta(null);
        this.panelListarCuenta.RefrescarDatos();
        this.panelListarCuenta.repaint();
    }

    @Override
    public void bajaTarjeta(String codigoTarjeta) {

    }

    @Override
    public void altaTarjeta(Tarjeta tarjeta) {

    }

    @Override
    public void modificacionTarjeta(Tarjeta tarjeta) {

    }
    // </editor-fold>
}
