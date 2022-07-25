package edu.up.Entidades;

public class Movimiento {
    private String codigoCuenta;
    private String codigoMovimiento;

    private String tipoMovimiento;
    private Float monto;

    public Movimiento(String codigoCuenta, String codigoMovimiento, String tipoMovimiento, Float monto) {
        this.codigoCuenta = codigoCuenta;
        this.codigoMovimiento = codigoMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.monto = monto;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getCodigoMovimiento() {
        return codigoMovimiento;
    }

    public void setCodigoMovimiento(String codigoMovimiento) {
        this.codigoMovimiento = codigoMovimiento;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
}
