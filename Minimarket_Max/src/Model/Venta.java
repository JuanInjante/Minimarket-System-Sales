package Model;

import java.util.Date;
import java.util.ArrayList;

public class Venta {

    private int codVenta;
    private int codCliente;
    private String codigo_empleado;
    private Date fecha_hora_venta;
    private String tipoComprobante;
    private double total;
    private double igv;
    private byte estado;
    private ArrayList<DetalleVenta> detalle;

    public Venta() {
    }

    public Venta(int codVenta, int codCliente, String codigo_empleado, Date fecha_hora_venta, String tipoComprobante, double total, double igv, byte estado, ArrayList<DetalleVenta> detalle) {
        this.codVenta = codVenta;
        this.codCliente = codCliente;
        this.codigo_empleado = codigo_empleado;
        this.fecha_hora_venta = fecha_hora_venta;
        this.tipoComprobante = tipoComprobante;
        this.total = total;
        this.igv = igv;
        this.estado = estado;
        this.detalle = detalle;
    }

    public Venta(int codVenta, int codCliente, String codigo_empleado, Date fecha_hora_venta, String tipoComprobante, double total, byte estado) {
        this.codVenta = codVenta;
        this.codCliente = codCliente;
        this.codigo_empleado = codigo_empleado;
        this.fecha_hora_venta = fecha_hora_venta;
        this.tipoComprobante = tipoComprobante;
        this.total = total;
        this.estado = estado;
    }

    public int getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(int codVenta) {
        this.codVenta = codVenta;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(String codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public Date getFecha_hora_venta() {
        return fecha_hora_venta;
    }

    public void setFecha_hora_venta(Date fecha_hora_venta) {
        this.fecha_hora_venta = fecha_hora_venta;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public ArrayList<DetalleVenta> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<DetalleVenta> detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Venta{" + "codVenta=" + codVenta + ", codCliente=" + codCliente + ", codigo_empleado=" + codigo_empleado + ", fecha_hora_venta=" + fecha_hora_venta + ", tipoComprobante=" + tipoComprobante + ", total=" + total + ", igv=" + igv + ", estado=" + estado + ", detalle=" + detalle + '}';
    }

    public double calcularMontoFinal() {
        double totalAntesDeImpuestos = 0.0;

        for (DetalleVenta detalle : detalle) {
            
            double subtotal = detalle.calcular_Subtotal();
            totalAntesDeImpuestos += subtotal;
        }   

        this.igv = totalAntesDeImpuestos * 0.18;
        this.total = totalAntesDeImpuestos + this.igv;
        
        return total;
    }

}
