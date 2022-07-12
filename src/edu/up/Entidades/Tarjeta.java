package edu.up.Entidades;

public class Tarjeta {


    private String codigoTarjeta;
    private int dniPropietario;
    private float limite;
    private float saldoTarjeta;


    public Tarjeta(int dniPropietario, float limite, float saldoTarjeta) {
        this.codigoTarjeta = codigoTarjeta;
        this.dniPropietario = dniPropietario;
        this.limite = limite;
        this.saldoTarjeta = saldoTarjeta;

    }

    public int getDniPropietario() {
        return dniPropietario;
    }
    public void setDniPropietario(int dniPropietario) {
        this.dniPropietario = dniPropietario;
    }
    public float getLimite() {
        return limite;
    }
    public void setLimite(float limite) {
        this.limite = limite;
    }
    public float getSaldoTarjeta() {
        return saldoTarjeta;
    }
    public void setSaldoTarjeta(float saldoTarjeta) {
        this.saldoTarjeta = saldoTarjeta;
    }
    public String getCodigoTarjeta() {return codigoTarjeta;}
    public void setCodigoTarjeta(String codigo) {this.codigoTarjeta = codigoTarjeta;}
}
