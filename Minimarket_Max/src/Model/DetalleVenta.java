package Model;

public class DetalleVenta {

    private int codDetalle;
    private Venta codVenta;
    private Producto codProducto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    public DetalleVenta() {
    }

    public DetalleVenta(int codDetalle, Venta codVenta, Producto codProducto, int cantidad, double precioUnitario, double subtotal) {
        this.codDetalle = codDetalle;
        this.codVenta = codVenta;
        this.codProducto = codProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public int getCodDetalle() {
        return codDetalle;
    }

    public void setCodDetalle(int codDetalle) {
        this.codDetalle = codDetalle;
    }

    public Venta getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(Venta codVenta) {
        this.codVenta = codVenta;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "codDetalle=" + codDetalle + ", codVenta=" 
                + codVenta + ", codProducto="
                + codProducto + ", cantidad=" + cantidad + ", precioUnitario="
                + precioUnitario + ", subtotal=" + subtotal + '}';
    }
     
    public double calcular_Subtotal(){
        subtotal = cantidad * precioUnitario;
        return subtotal;
    }
}
