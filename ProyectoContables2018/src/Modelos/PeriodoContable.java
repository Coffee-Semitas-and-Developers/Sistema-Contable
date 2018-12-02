package Modelos;
import java.sql.Date;

/**
 *
 * @author Elmer
 */
public class PeriodoContable {
    public int idPeriodoContable;
    Date fechaInicio;
    Date fechaFin;

    public int getIdPeriodoContable() {
        return idPeriodoContable;
    }

    public void setIdPeriodoContable(int idPeriodoContable) {
        this.idPeriodoContable = idPeriodoContable;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
}
