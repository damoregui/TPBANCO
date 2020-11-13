package edu.up.ui.ControlesVisuales;
import edu.up.Excepciones.ExcepcionConexionDB;

public class ControlInteger extends ControlBase
{
    public Integer getValor()
    {
        return Integer.valueOf( this.textfield.getText() );
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
