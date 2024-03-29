package edu.up.ui.Vistas;

import edu.up.Entidades.Cuenta;
import edu.up.Entidades.Tarjeta;
import edu.up.Excepciones.DatoInvalidoException;
import edu.up.Excepciones.ExcepcionTarjeta;
import edu.up.Excepciones.ExcepcionCuenta;
import edu.up.Main;
import edu.up.Mensajeria;
import edu.up.Negocio.CuentaBO;
import edu.up.Negocio.IObservadorDeBussinessObject;
import edu.up.Negocio.IObservadorDeBussinessObjectTarjeta;
import edu.up.Negocio.TarjetaBO;
import edu.up.ServicioErrores;

import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;

public class HandlerAplicacion implements IObservadorDeBussinessObject, IObservadorDeBussinessObjectTarjeta {
    private MenuPrincipalUser formularioUser;
    private MenuPrincipal formulario;
    private final CuentaBO negocio;
    private final TarjetaBO negocioTarjeta;
    private CuentaFormABM panelABMCuenta;
    private CuentaFormListar panelListarCuenta;
    private CuentaFormTransferir panelTransferirCuenta;
    private TarjetaFormABM panelABMTarjeta;
    private TarjetaFormListar panelListarTarjeta;

    public HandlerAplicacion(MenuPrincipal formulario) {
        this.formulario = formulario;
        this.negocio = new CuentaBO();
        this.negocio.agregarObservador(this);

        this.negocioTarjeta = new TarjetaBO();
        this.negocioTarjeta.agregarObservador(this);

        this.panelABMCuenta = this.createCuentaPanel();
        this.panelListarCuenta = this.createListarCuentasPanel();
        this.panelTransferirCuenta = this.createTransferirCuentasPanel();

        this.panelABMTarjeta = this.createTarjetaPanel();
        this.panelListarTarjeta = this.createListarTarjetasPanel();
    }

    public HandlerAplicacion(MenuPrincipalUser formularioUser) {

        this.formularioUser = formularioUser;
        this.negocio = new CuentaBO();
        this.negocio.agregarObservador(this);

        this.negocioTarjeta = new TarjetaBO();
        this.negocioTarjeta.agregarObservador(this);

        this.panelABMCuenta = this.createCuentaPanel();
        this.panelListarCuenta = this.createListarCuentasPanel();
        this.panelTransferirCuenta = this.createTransferirCuentasPanel();

        this.panelABMTarjeta = this.createTarjetaPanel();
        this.panelListarTarjeta = this.createListarTarjetasPanel();
    }

    private void activarPanel(JPanel panel) {
        this.formulario.getContentPane().setVisible(false);
        this.formulario.setContentPane(panel);
        panel.setVisible(true);
        this.formulario.revalidate();
        this.formulario.repaint();
    }
    private void activarPanelUser(JPanel panel) {
        this.formularioUser.getContentPane().setVisible(false);
        this.formularioUser.setContentPane(panel);
        panel.setVisible(true);
        this.formularioUser.revalidate();
        this.formularioUser.repaint();
    }


    public void activarPanelVistaUsuario(ActionEvent e) {
        //MenuPrincipalUser menu2 = new MenuPrincipalUser();
        //new HandlerAplicacion(menu2);
        try {
            Main.menuUsuario.mostrar();
            Main.menuAdministrador.ocultar();
        } catch (DatoInvalidoException ex) {
            //custom title, error icon
            JOptionPane.showMessageDialog(Main.menuAdministrador,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(ex);
        }
    }

    public void activarPanelAdmin(ActionEvent e) {
        //MenuPrincipal menu = new MenuPrincipal();
        //new HandlerAplicacion(menu);
        Main.menuAdministrador.mostrar();
        Main.menuUsuario.ocultar();
    }
    // <editor-fold defaultstate="collapsed" desc="Manejo de eventos del menu">
    public void activarPanelCrearCuenta(ActionEvent e) {
        this.panelABMCuenta.setearEntidad(new Cuenta("", 0, "", "", 0, 0, 0));
        this.activarPanel(this.panelABMCuenta);
    }



    public void activarPanelListarCuenta(ActionEvent e) {
        this.panelListarCuenta.RefrescarDatos();
        this.activarPanel(this.panelListarCuenta);
    }
    // CREAR EL RESTO DE LOS ACTIVARPANELLISTARUSUARIO       TAMBIÉN (ESTO ESTA VISTO CON J)
    public void activarPanelListarCuentaUsuario(ActionEvent e, int dni) {
        this.panelListarCuenta.RefrescarDatosUsuario(dni);
        this.activarPanelUser(this.panelListarCuenta);
    }
    public void activarPanelTransferirCuenta(ActionEvent e, int dni) {
        this.panelTransferirCuenta.RefrescarDatosUsuario(dni);
        this.activarPanelUser(this.panelTransferirCuenta);
    }
    public void activarPanelCrearTarjeta(ActionEvent e) {
        this.panelABMTarjeta.setearEntidadTarjeta(new Tarjeta(0, 0, 0));
        this.activarPanel(this.panelABMTarjeta);
    }
    public void activarPanelListarTarjeta(ActionEvent e) {
        this.panelListarTarjeta.RefrescarDatos();
        this.activarPanel(this.panelListarTarjeta);
    }

    public void activarPanelListarTarjetaUsuario(ActionEvent e, int dni) {
        this.panelListarTarjeta.RefrescarDatosUsuario(dni);
        this.activarPanelUser(this.panelListarTarjeta);
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

    private CuentaFormTransferir createTransferirCuentasPanel() {
        return new CuentaFormTransferir(this);
    }

    private TarjetaFormListar createListarTarjetasPanel() {
        return new TarjetaFormListar(this);
    }


    public void modificarCuenta(Cuenta cuenta) {
        this.panelABMCuenta.setearEntidad(cuenta);
        this.activarPanel(this.panelABMCuenta);
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

 public List<Cuenta> listarCuentasPorDni(int dni) {
      List<Cuenta> retorno = new LinkedList ();

      try {
          retorno = this.negocio.listarCuentas(dni);
      } catch (ExcepcionCuenta ex) {
          ServicioErrores.getInstancia().informarError(ex);
      }
      return retorno;
  }

    public Cuenta listarCuentasPorCodigo(String codigo) {
        Cuenta retorno = null;

        try {
            retorno = this.negocio.devolverCuenta(codigo);
        } catch (ExcepcionCuenta ex) {
            ServicioErrores.getInstancia().informarError(ex);
        }
        return retorno;
    }

    public List<Tarjeta> listarTarjetasPorDni(int dni) {
        List<Tarjeta> retorno = new LinkedList ();

        try {
            retorno = this.negocioTarjeta.listarTarjetas(dni);
        } catch (ExcepcionTarjeta ex) {
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
        Mensajeria.getInstancia().MostrarInformacion( "Baja" + codigo  );
        this.panelListarCuenta.actualizarListaPorCodigoEliminado(codigo);
        this.panelListarCuenta.repaint();
    }

    public void alta(Cuenta cuenta) {
        Mensajeria.getInstancia().MostrarInformacion("Se ha creado la cuenta");
        this.activarPanelListarCuenta(null);
    }

    public void modificacion(Cuenta cuenta) {
        Mensajeria.getInstancia().MostrarInformacion("Se ha modificado la cuenta " + cuenta.getCodigo());
        this.activarPanelListarCuenta(null);
        this.panelListarCuenta.RefrescarDatos();
        this.panelListarCuenta.repaint();
    }

    @Override
    public void transferencia(Cuenta cuenta) {
        Mensajeria.getInstancia().MostrarInformacion("Se ha realizado la tranferencia de la cuenta " + cuenta.getCodigo());
        this.activarPanelListarCuentaUsuario(null, cuenta.getDni());
        this.panelListarCuenta.RefrescarDatosUsuario(cuenta.getDni());
        this.panelListarCuenta.repaint();

    }

    public void transferenciaCuentas(Cuenta cuentaOrigen, Cuenta cuentaDestino, float monto) throws ExcepcionCuenta {
        try {
            this.negocio.transferirMonto(cuentaOrigen, cuentaDestino, monto);
        }catch (ExcepcionCuenta ex){
            ServicioErrores.getInstancia().informarError(ex);
        }
    }

    @Override
    public void bajaTarjeta(String codigoTarjeta) {

    }

    @Override
    public void altaTarjeta(Tarjeta tarjeta) {
        Mensajeria.getInstancia().MostrarInformacion("Se ha creado la Tarjeta");
        this.activarPanelListarTarjeta(null);
    }

    @Override
    public void modificacionTarjeta(Tarjeta tarjeta) {

    }

    // </editor-fold>
}
