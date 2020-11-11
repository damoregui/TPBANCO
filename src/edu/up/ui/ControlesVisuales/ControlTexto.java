package edu.up.ui.ControlesVisuales;

public class ControlTexto extends ControlBase
{
    public String getValor()
    {
        return this.textfield.getText();
    }

    public void setValor(String valor)
    {
        this.textfield.setText(valor);
    }
    
    public ControlTexto( String etiqueta )
    {
        super(etiqueta);
    }
    
}
