package edu.up.ui.Vistas;

import edu.up.Entidades.Tarjeta;

import javax.swing.table.AbstractTableModel;
import java.util.List;


public class ModeloTarjetas extends AbstractTableModel
{
    private final List<Tarjeta> tarjetas;

    public ModeloTarjetas(List<Tarjeta> tarjetas){
    this.tarjetas = tarjetas;
}
    
    @Override
    public int getRowCount() {
        return tarjetas.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    // valores del listar
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tarjeta tarjeta = tarjetas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tarjeta.getDniPropietario();
            case 1:
                return tarjeta.getCodigoTarjeta();
            case 2:
                return tarjeta.getLimite();
            case 3:
                return tarjeta.getSaldoTarjeta();
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
                return "Codigo";
            case 2:
                return "Limite";
            case 3:
                return "saldo Tarjeta";
        }
        return null;
    }
}
