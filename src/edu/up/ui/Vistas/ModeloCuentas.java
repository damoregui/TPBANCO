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
        return 4;
    }

    // valores del listar
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuenta cuenta = cuentas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cuenta.getDni();
            case 1:
                return cuenta.getNombre();
            case 2:
                return cuenta.getTipoCuenta();
            case 3:
                return cuenta.getSaldo();
        }
        return null;
    }

    //Columnas del listar
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Dni";
            case 1:
                return "Nombre";
            case 2:
                return "tipo";
            case 3:
                return "saldo";
        }
        return null;
    }
}
