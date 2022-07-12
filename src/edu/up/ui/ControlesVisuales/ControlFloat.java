package edu.up.ui.ControlesVisuales;

import edu.up.Excepciones.ExcepcionCuenta;
import edu.up.Excepciones.ExcepcionTarjeta;

public class ControlFloat extends ControlBase
{
    public Float getValor() throws ExcepcionCuenta {
        try {
            return Float.valueOf(this.textfield.getText());
        } catch (NumberFormatException excepcion) {
            throw new ExcepcionCuenta("El valor del campo no es numérico, ingrese un valor válido", excepcion);
        }
    }

    public Float getValorTarjeta() throws ExcepcionTarjeta {
        try {
            return Float.valueOf(this.textfield.getText());
        } catch (NumberFormatException excepcion) {
            throw new ExcepcionTarjeta("El valor del campo 'saldo' no es correcto, ingrese un valor válido", excepcion);
        }
    }

    public void setValor( Float valor )
    {
        this.textfield.setText( valor.toString() );
    }
    
    public ControlFloat( String etiqueta )
    {
        super( etiqueta );
    }
     
}
