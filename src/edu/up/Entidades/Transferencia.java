package edu.up.Entidades;

// Se usará para la entrega final //

public class Transferencia {
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private float monto;
    private String motivoTransferencia;

    public Transferencia (Cuenta cuentaOrigen, Cuenta cuentaDestino, String motivoTransferencia){
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.motivoTransferencia = motivoTransferencia;

    }
    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public String getMotivoTransferencia() {
        return motivoTransferencia;
    }

    // no tiene sentido tener seters porque no voy a cambiarle

}
