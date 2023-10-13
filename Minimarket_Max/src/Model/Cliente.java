package Model;

public class Cliente {

    private int codCliente;
    private String nombre;
    private String ap_pat;
    private String ap_mat;
    private int dni;
    private String telefono;
    private String direccion;
    private String correo_electronico;
    private String genero;
    private byte estado;

    public Cliente() {
    }

    public Cliente(int codCliente, String nombre, String ap_pat, String ap_mat, int dni, String telefono, String direccion, String correo_electronico, String genero, byte estado) {
        this.codCliente = codCliente;
        this.nombre = nombre;
        this.ap_pat = ap_pat;
        this.ap_mat = ap_mat;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.genero = genero;
        this.estado = estado;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_pat() {
        return ap_pat;
    }

    public void setAp_pat(String ap_pat) {
        this.ap_pat = ap_pat;
    }

    public String getAp_mat() {
        return ap_mat;
    }

    public void setAp_mat(String ap_mat) {
        this.ap_mat = ap_mat;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codCliente=" + codCliente + ", nombre=" + nombre + ", ap_pat=" + ap_pat + ", ap_mat=" + ap_mat + ", dni=" + dni + ", telefono=" + telefono + ", direccion=" + direccion + ", correo_electronico=" + correo_electronico + ", genero=" + genero + ", estado=" + estado + '}';
    }

}
