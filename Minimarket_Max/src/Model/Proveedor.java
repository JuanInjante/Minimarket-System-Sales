package Model;

public class Proveedor {

    private int codProveedor;
    private String nombreEmpresa;
    private String nombre_contacto;
    private String telefono;
    private byte estado;

    public Proveedor() {
    }

    public Proveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public Proveedor(int codProveedor, String nombreEmpresa, String nombre_contacto, String telefono, byte estado) {
        this.codProveedor = codProveedor;
        this.nombreEmpresa = nombreEmpresa;
        this.nombre_contacto = nombre_contacto;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "codProveedor=" + codProveedor + ", nombreEmpresa=" + nombreEmpresa
                + ", nombre_contacto=" + nombre_contacto + ", telefono=" + telefono + ", estado=" + estado + '}';
    }
}
