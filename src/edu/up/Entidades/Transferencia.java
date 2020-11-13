package edu.up.Entidades;

// Se usará para la entrega final //

public class Transferencia {
    private int cuentaOrigen;
    private int cuentaDestino;
    private String motivoTransferencia;

    public Transferencia (int cuentaOrigen, int cuentaDestino, String motivoTransferencia){
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.motivoTransferencia = motivoTransferencia;

    }

    public int getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(int cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public int getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(int cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public String getMotivoTransferencia() {
        return motivoTransferencia;
    }

    public void setMotivoTransferencia(String motivoTransferencia) {
        this.motivoTransferencia = motivoTransferencia;
    }


}
