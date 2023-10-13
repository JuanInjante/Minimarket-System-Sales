package Model;

import java.util.Date;

public class Producto {

    private int codProducto;
    private int codProveedor;
    private int codCategoria;
    private String nombre;
    private String descripcion;
    private Date fecha_vencimiento;
    private Date fecha_creacion;
    private Date fecha_modificacion;
    private String unidadMedida;
    private byte estado;

    public Producto() {
    }

    public Producto(int codProducto) {
        this.codProducto = codProducto;
    }

    public Producto(int codProducto, int codProveedor, int codCategoria, String nombre, String descripcion, Date fecha_vencimiento, Date fecha_creacion, Date fecha_modificacion, String unidadMedida, byte estado) {
        this.codProducto = codProducto;
        this.codProveedor = codProveedor;
        this.codCategoria = codCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_vencimiento = fecha_vencimiento;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.unidadMedida = unidadMedida;
        this.estado = estado;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" + "codProducto=" + codProducto + ", codProveedor=" + codProveedor + ", codCategoria=" + codCategoria + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha_vencimiento=" + fecha_vencimiento + ", fecha_creacion=" + fecha_creacion + ", fecha_modificacion=" + fecha_modificacion + ", unidadMedida=" + unidadMedida + ", estado=" + estado + '}';
    }
}
