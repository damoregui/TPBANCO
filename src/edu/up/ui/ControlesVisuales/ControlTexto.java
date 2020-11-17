package edu.up.ui.ControlesVisuales;

import edu.up.Excepciones.ExcepcionCuenta;

public class ControlTexto extends ControlBase
{
    public String getValor() throws ExcepcionCuenta {
        try {
            return this.textfield.getText();
        } catch (StringIndexOutOfBoundsException excepcion) {
            throw new ExcepcionCuenta("El valor del texto no es valido", excepcion);
        } }

    public void setValor(String valor)
    {
        this.textfield.setText(valor);
    }
    
    public ControlTexto( String etiqueta )
    {
        super(etiqueta);
    }
    
}
