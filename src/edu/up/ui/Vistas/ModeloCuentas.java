package edu.up.ui.Vistas;

import edu.up.Entidades.Cuenta;

import javax.swing.table.AbstractTableModel;
import java.util.List;


public class ModeloCuentas extends AbstractTableModel
{
    private final List<Cuenta> cuentas;

    public ModeloCuentas(List<Cuenta> cuentas){
    this.cuentas = cuentas;
}
    
    @Override
    public int getRowCount() {
        return cuentas.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    // valores del listar
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuenta cuenta = cuentas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cuenta.getCodigo();

            case 1:
                return cuenta.getDni();

            case 2:
                return cuenta.getNombre();

            case 3:
                return cuenta.getTipoCuenta();

            case 4:
                return cuenta.getSaldo();

            case 5:
                return cuenta.getDebito();

            case 6:
                return cuenta.getCredito();
        }
        return null;
    }

    //Columnas del listar
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Codigo";
            case 1:
                return "Dni";
            case 2:
                return "Nombre";
            case 3:
                return "tipo";
            case 4:
                return "saldo";
            case 5:
                return "debito";
            case 6:
                return "credito";
        }
        return null;
    }
}
