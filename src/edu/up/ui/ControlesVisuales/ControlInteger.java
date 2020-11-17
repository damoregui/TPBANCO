package edu.up.ui.ControlesVisuales;
import edu.up.Excepciones.ExcepcionConexionDB;
import edu.up.Excepciones.ExcepcionCuenta;

public class ControlInteger extends ControlBase
{
    public Integer getValor() throws ExcepcionCuenta {
        try {
            return Integer.valueOf(this.textfield.getText());
        } catch (NumberFormatException excepcion) {
            throw new ExcepcionCuenta("El valor del campo no es numérico", excepcion); //return de una excepcion
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
