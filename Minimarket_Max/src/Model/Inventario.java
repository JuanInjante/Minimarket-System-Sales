package Model;

import java.util.Date;

public class Inventario {

    private int codInventario;
    private int codProducto;
    private int codPersona;
    private int stock;
    private Date fecha_hora_entrada;
    private double precioCompra;
    private byte estado;

    public Inventario() {
    }

    public Inventario(int codInventario, int codProducto, int codPersona, int stock, Date fecha_hora_entrada, double precioCompra, byte estado) {
        this.codInventario = codInventario;
        this.codProducto = codProducto;
        this.codPersona = codPersona;
        this.stock = stock;
        this.fecha_hora_entrada = fecha_hora_entrada;
        this.precioCompra = precioCompra;
        this.estado = estado;
    }

    public int getCodInventario() {
        return codInventario;
    }

    public void setCodInventario(int codInventario) {
        this.codInventario = codInventario;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFecha_hora_entrada() {
        return fecha_hora_entrada;
    }

    public void setFecha_hora_entrada(Date fecha_hora_entrada) {
        this.fecha_hora_entrada = fecha_hora_entrada;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Inventario{" + "codInventario=" + codInventario + ", codProducto=" + codProducto + ", codPersona=" + codPersona + ", stock=" + stock + ", fecha_hora_entrada=" + fecha_hora_entrada + ", precioCompra=" + precioCompra + ", estado=" + estado + '}';
    }

}
