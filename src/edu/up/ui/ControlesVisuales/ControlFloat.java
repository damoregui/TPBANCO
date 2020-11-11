package edu.up.ui.ControlesVisuales;

public class ControlFloat extends ControlBase
{
    public Float getValor()
    {
        return Float.valueOf( this.textfield.getText() );
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
