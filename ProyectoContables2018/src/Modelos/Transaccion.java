package Modelos;
import java.util.Date;

/**
 *
 * @author Elmer
 */
public class Transaccion {
    public int idTransaccion;
    public String descripcion;
    public Date fecha;
    public double monto;
    public PeriodoContable idPeriodoContable;
    public DetalleTransaccion detalleTransaccion;

    public DetalleTransaccion getDetalleTransaccion() {
        return detalleTransaccion;
    }

    public void setDetalleTransaccion(DetalleTransaccion detalleTransaccion) {
        this.detalleTransaccion = detalleTransaccion;
    }

    public PeriodoContable getIdPeriodoContable() {
        return idPeriodoContable;
    }

    public void setIdPeriodoContable(PeriodoContable idPeriodoContable) {
        this.idPeriodoContable = idPeriodoContable;
    }
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
