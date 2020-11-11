package edu.up;

import javax.swing.JOptionPane;

public class Mensajeria
{
    private static Mensajeria instancia = null;
    
    private Mensajeria()
    {
    }
    
    public static Mensajeria getInstancia()
    {
        if( instancia == null )
        {
            instancia = new Mensajeria();
        }
        return instancia;
    }
    
    private void MostrarPopUp( String mensaje, String titulo, int tipo )
    {
        JOptionPane.showMessageDialog( null, mensaje, titulo, tipo );
    }
    
    public void MostrarError( String mensaje )
    {
        this.MostrarPopUp( mensaje, "Error", JOptionPane.ERROR_MESSAGE );
    }
    
    public void MostrarInformacion( String mensaje )
    {   
        this.MostrarPopUp( mensaje, "Información", JOptionPane.INFORMATION_MESSAGE );
    }
        
}
