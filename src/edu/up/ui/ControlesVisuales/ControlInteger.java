package edu.up.ui.ControlesVisuales;
import edu.up.Excepciones.ExcepcionConexionDB;
import edu.up.Excepciones.ExcepcionCuenta;
import edu.up.Excepciones.ExcepcionTarjeta;

public class ControlInteger extends ControlBase
{
    public Integer getValor() throws ExcepcionCuenta {
        try {
            return Integer.valueOf(this.textfield.getText());
        } catch (NumberFormatException excepcion) {
            throw new ExcepcionCuenta("El valor del campo no es numérico", excepcion); //return de una excepcion de las cuentas
        }
    }

    public Integer getValorTarjeta() throws ExcepcionTarjeta {
        try {
            return Integer.valueOf(this.textfield.getText());
        } catch (NumberFormatException excepcion) {
            throw new ExcepcionTarjeta("El valor del campo no es numérico", excepcion); //return de la exepción de las tarjetas
        }
    }

    public void setValor( Integer valor )
    {
        this.textfield.setText( valor.toString() );
    }
    
    public ControlInteger( String etiqueta )
    {
        super( etiqueta );
    }
    
}
