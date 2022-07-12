package edu.up.Negocio;

import edu.up.Entidades.Tarjeta;
import edu.up.Excepciones.ExcepcionTarjeta;
import edu.up.dao.TarjetaDAO;
import edu.up.dao.IObservadorDeDaoTarjeta;
import edu.up.dao.impl.TarjetaDAOImpl;
import java.util.List;

public class TarjetaBO extends BussinessObjectObservableTarjeta implements IObservadorDeDaoTarjeta // el implents hace referencia a interfaz. IObservadorDeDao define solamente comportamiento . Me define los mètodos que tiene que tener cualqueir clse que quiera ser observadora de un dao
{
    private final TarjetaDAO tarjetaDao;

    public TarjetaBO() {
        this.tarjetaDao = new TarjetaDAOImpl();
        this.tarjetaDao.agregarObservador(this);
    }

    public TarjetaBO(TarjetaDAO dao) {
        this.tarjetaDao = dao;
        this.tarjetaDao.agregarObservador(this);
    }

    public void grabarTarjeta(Tarjeta tarjeta) throws ExcepcionTarjeta {
        if (tarjeta.getDniPropietario()>0) {
            tarjetaDao.insert(tarjeta);
        } else {
            tarjetaDao.update(tarjeta);
        }
    }

    public void eliminarTarjeta(Tarjeta tarjeta) throws ExcepcionTarjeta {
        tarjetaDao.delete(tarjeta);
    }

    public List<Tarjeta> listarTarjetas() throws ExcepcionTarjeta {
        return tarjetaDao.list();
    }

// @Override
   public void altaEnDaoTarjeta( Tarjeta tarjeta )
   {
       this.notificarAltaTarjeta( tarjeta );
   }
// verride
   public void bajaEnDaoTarjeta( String codigoTarjeta )
   {
       this.notificarBajaTarjeta( codigoTarjeta );
   }

   public void modificacionEnDaoTarjeta( Tarjeta tarjeta)
   {
       this.notificarModificacionTarjeta( tarjeta );
   }
}