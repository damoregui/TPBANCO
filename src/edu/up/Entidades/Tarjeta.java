package edu.up.Entidades;


// Se usará para la entrega final //


public class Tarjeta {
    private int dniPropietario;
    private String marca;
    private String limite;
    private int saldoTarjeta;


    public Tarjeta(int dniPropietario, String marca, String limite, int saldoTarjeta) {
        this.dniPropietario = dniPropietario;
        this.marca = marca;
        this.limite = limite;
        this.saldoTarjeta = saldoTarjeta;

    }

    public int getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(int dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLimite() {
        return limite;
    }

    public void setLimite(String limite) {
        this.limite = limite;
    }
    public int getSaldoTarjeta() {
        return saldoTarjeta;
    }

    public void setSaldoTarjeta(int saldo) {
        this.saldoTarjeta = saldoTarjeta;
    }
}
