package edu.up.ui.Vistas;

import edu.up.Entidades.Cuenta;
import edu.up.Excepciones.ExcepcionCuenta;
import edu.up.ServicioErrores;
import edu.up.ui.ControlesVisuales.ControlFloat;
import edu.up.ui.ControlesVisuales.ControlInteger;
import edu.up.ui.ControlesVisuales.ControlTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CuentaFormTransferir extends Form {
    private ControlTexto controlNombre; // nuevo
    private ControlFloat controlSaldoDisponible; // nuevo

    public ControlTexto getControlNombre() {
        return controlNombre;
    } // nuevo

    public ControlFloat getControlSaldo() {
        return controlSaldoDisponible;
    } // nuevo

    private Cuenta datosParaTransferir;  // nuevo
    private List<Cuenta> cuentas;


    public CuentaFormTransferir(HandlerAplicacion handler) {
        super(handler);
    }

    public void RefrescarDatos() {
        this.cuentas.clear();
        this.cuentas.addAll(this.handler.listarCuentas());
    }

    public void RefrescarDatosUsuario(int dni) {
        this.cuentas.clear();
        this.cuentas.addAll(this.handler.listarCuentasPorDni(dni));
    }

    public void actualizarListaPorCodigoEliminado(String codigo) {
        this.cuentas.removeIf(x -> x.getCodigo() == codigo);
    }

    // <editor-fold defaultstate="collapsed" desc="Implementacion de Form">
    @Override
    protected String obtenerTitulo() {
        return "¿Desde que cuenta desea transferir?";
    }

    @Override
    protected void dibujarFormulario() {
        this.cuentas = this.handler.listarCuentas();
        JTable grilla = new JTable(new ModeloCuentas(this.cuentas));
        JScrollPane listar = new JScrollPane(grilla);
        listar.setMaximumSize(new Dimension(800, 600));

        //======================================================================================================//
        //=================================== DEFINO EL CONTAINER TRANSFERIR=================================== //
        //======================================================================================================//
        Container transferir = new JPanel();
        transferir.setSize(400, 100);
        transferir.setLayout(new BoxLayout(transferir, BoxLayout.X_AXIS));

        //======================================================================================================//
        //=================================== DEFINO EL CONTAINER DESTINO ===================================== //
        //======================================================================================================//
        Container destino = new JPanel();
        destino.setSize(200, 100);
        destino.setLayout(new BoxLayout(destino, BoxLayout.LINE_AXIS));

        JLabel labelparadestino = new JLabel("Ingrese cuenta destino       ");
        JTextField cuentaDestinoEscrita = new JTextField();
        cuentaDestinoEscrita.setMinimumSize(new Dimension(100, 50));
        cuentaDestinoEscrita.setMaximumSize(new Dimension(200, 400));
        destino.add(labelparadestino);
        destino.add(cuentaDestinoEscrita);

        //======================================================================================================//
        //=================================== DEFINO EL CONTAINER MONTO   ===================================== //
        //======================================================================================================//
        Container montoATransferir = new JPanel();
        montoATransferir.setSize(200, 100);
        montoATransferir.setLayout(new BoxLayout(montoATransferir, BoxLayout.LINE_AXIS));

        JLabel labelparamonto = new JLabel("Ingrese monto a Transferir");
        JTextField montoEscrito = new JTextField();
        montoEscrito.setMinimumSize(new Dimension(100, 50));
        montoEscrito.setMaximumSize(new Dimension(200, 400));
        montoATransferir.add(labelparamonto);
        montoATransferir.add(montoEscrito);


        JButton botontransferir = new JButton("Transferir");


        botontransferir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int cuentaOrigen = grilla.getSelectedRow();
                    if (cuentaOrigen == -1) {
                        ServicioErrores.getInstancia().informarError("Elegí una cuenta, manco de mierda ");
                        return;
                    }
                    Cuenta cuentaOrigen1 = cuentas.get(cuentaOrigen);
                    String text = cuentaDestinoEscrita.getText();
                    if (text.isEmpty()) {
                        ServicioErrores.getInstancia().informarError("Pone la cuenta de destino, forro ");
                        return;
                    }
                    Cuenta cuentaDestino = handler.listarCuentasPorCodigo(text);
                    if (cuentaDestino == null) {
                        ServicioErrores.getInstancia().informarError("la manqueASte con el codigo de cuenta idiota ");
                        return;
                    }
                    String montochequeo = montoEscrito.getText();
                    if (montochequeo.isEmpty()                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ) {
                        ServicioErrores.getInstancia().informarError("No tenes guita, no sos ricardo fort ");
                        return;
                    }
                    float monto = Float.parseFloat(montoEscrito.getText());
                    if (monto >= cuentaOrigen1.getSaldo() || monto <= 0) {
                        ServicioErrores.getInstancia().informarError("No tenes guita, no sos ricardo fort ");
                        return;
                    }
                    handler.transferenciaCuentas(cuentaOrigen1, cuentaDestino, monto);
                } catch (ExcepcionCuenta ex) {
                    ServicioErrores.getInstancia().informarError(ex, "Error en la transferencia. Intente nuevamente ");
                    return;
                }
            }
        });

        //======================================================================================================//
        //=================================== AGREGAR LOS CONTAINERS AL FORM ================================== //
        //======================================================================================================//

        this.add(listar);
        this.add(Box.createHorizontalStrut(10));
        this.add(Box.createHorizontalStrut(10));
        this.add(montoATransferir);
        this.add(destino);
        this.add(botontransferir);
    }
    // </editor-fold>
}