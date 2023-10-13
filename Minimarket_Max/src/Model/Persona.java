package Model;

import java.util.Date;

public class Persona {

    private int codPersona;
    private String codigo;
    private String nombre;
    private String ap_pat;
    private String ap_mat;
    private int dni;
    private Date fechaContrato;
    private int salario;
    private String usuario;
    private String contrasena;
    private byte[] salt;
    private String cargo;
    private byte estado;

    public Persona() {

    }

    public Persona(int codPersona, String codigo, String nombre, String ap_pat, String ap_mat, int dni, Date fechaContrato, int salario, String usuario, String contrasena, byte[] salt, String cargo, byte estado) {
        this.codPersona = codPersona;
        this.codigo = codigo;
        this.nombre = nombre;
        this.ap_pat = ap_pat;
        this.ap_mat = ap_mat;
        this.dni = dni;
        this.fechaContrato = fechaContrato;
        this.salario = salario;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.salt = salt;
        this.cargo = cargo;
        this.estado = estado;
    }

    public Persona(int codPersona) {
        this.codPersona = codPersona;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Persona{" + "codPersona=" + codPersona + ", codigo=" + codigo + ", nombre=" + nombre + ", ap_pat=" + ap_pat + ", ap_mat=" + ap_mat + ", dni=" + dni + ", fechaContrato=" + fechaContrato + ", salario=" + salario + ", usuario=" + usuario + ", contrasena=" + contrasena + ", salt=" + salt + ", cargo=" + cargo + ", estado=" + estado + '}';
    }

}
