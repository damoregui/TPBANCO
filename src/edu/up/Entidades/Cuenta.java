package edu.up.Entidades;

public class Cuenta {

    private String codigo;
    private int dni;
    private String nombre;
    private String tipoCuenta;
    private float saldo;

    public Cuenta(String codigo, int dni, String nombre, String tipoCuenta, float saldo)
    {
        this.codigo = codigo;
        this.dni = dni;
        this.nombre = nombre;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo( String codigo )
    {
        this.codigo = codigo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int documentoDeIdentidad) {
        this.dni = documentoDeIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombre = nombreCompleto;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}




