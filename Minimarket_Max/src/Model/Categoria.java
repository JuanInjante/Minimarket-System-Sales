package Model;

public class Categoria {

    private int codCategoria;
    private String nombre;
    private byte estado;

    public Categoria() {
    }

    public Categoria(int codCategoria, String nombre, byte estado) {
        this.codCategoria = codCategoria;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Categoria(int codigoPersona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Categoria{" + "codCategoria=" + codCategoria + ", nombre=" + nombre + ", estado=" + estado + '}';
    }
}
