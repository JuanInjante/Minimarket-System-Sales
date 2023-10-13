package Dao;

import Config.Connect_DB;
import Model.Persona;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.*;

public class DaoPersona {

    private Connection cn;

    public DaoPersona() {
        Connect_DB connect_DB = new Connect_DB();
        this.cn = connect_DB.conectar();
    }

    public int insertarPersona(String codigo, String nombre, String ap_pat, String ap_mat, int dni,
            String fechaContrato, int salario, String usuario, String contrasena, String cargo) {

        String sql = "{CALL [dbo].[sp_insert_persona](?,?,?,?,?,?,?,?,?,?,?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {

            statement.setString(1, codigo);
            statement.setString(2, nombre);
            statement.setString(3, ap_pat);
            statement.setString(4, ap_mat);
            statement.setInt(5, dni);
            statement.setString(6, fechaContrato);
            statement.setInt(7, salario);
            statement.setString(8, usuario);
            statement.setString(9, contrasena);
            statement.setString(10, cargo);
            statement.setByte(11, (byte) 1);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("La persona se insertó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo insertar a la persona");
                    return 0;
                }
            } else {
                System.out.println("No se obtuvo resultado del procedimiento");
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int actualizarPersona(Persona persona) {

        String sql = "{CALL [dbo].[sp_update_persona](?,?,?,?,?,?,?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {

            statement.setInt(1, persona.getCodPersona());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getAp_pat());
            statement.setString(4, persona.getAp_mat());
            statement.setInt(5, persona.getSalario());
            statement.setString(6, persona.getUsuario());
            statement.setByte(7, persona.getEstado());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("La persona se actualizó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo actualizar a la persona");
                    return 0;
                }
            } else {
                System.out.println("No se obtuvo resultado del procedimiento");
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int eliminarPersona(Persona persona) {

        String sql = "{CALL [dbo].[sp_delete_persona](?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {
            statement.setInt(1, persona.getCodPersona());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("La persona se eliminó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo eliminar a la persona");
                    return 0;
                }
            } else {
                System.out.println("No se obtuvo resultado del procedimiento");
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Persona> buscarPersonas(String codigo, String nombre, String ap_pat, String ap_mat,
            int dni, Byte estado) {

        String sql = "{CALL [dbo].[sp_buscar_cliente](?,?,?,?,?,?)}";

        try (CallableStatement statement = cn.prepareCall(sql)) {

            statement.setString(1, codigo);
            statement.setString(2, nombre);
            statement.setString(3, ap_pat);
            statement.setString(4, ap_mat);
            statement.setInt(5, dni);

            if (estado != null) {

                statement.setByte(6, estado);
            } else {

                statement.setNull(6, java.sql.Types.TINYINT);
            }

            ResultSet resulset = statement.executeQuery();

            List<Persona> personas = new ArrayList<>();
            while (resulset.next()) {
                int codPersona = resulset.getInt("codPersona");
                String codigoResultado = resulset.getString("codigo");
                String nombreResultado = resulset.getString("nombre");
                String ap_patResultado = resulset.getString("ap_pat");
                String ap_matResultado = resulset.getString("ap_mat");
                int dniResultado = resulset.getInt("dni");
                java.sql.Date fechaContratoResultado = resulset.getDate("fechaContrato");
                int salarioResultado = resulset.getInt("salario");
                String usuarioResultado = resulset.getString("usuario");
                String contrasenaResultado = resulset.getString("contrasena");
                byte[] saltResultado = resulset.getBytes("salt");
                String cargoResultado = resulset.getString("cargo");
                byte estadoResultado = resulset.getByte("estado");

                Persona person = new Persona(codPersona, codigoResultado, nombreResultado, ap_patResultado,
                        ap_matResultado, dniResultado, fechaContratoResultado, salarioResultado,
                        usuarioResultado, contrasenaResultado, saltResultado, cargoResultado, estadoResultado);
                personas.add(person);
            }
            return personas;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    public boolean verificarContrasena(String usuario, String contrasena) {
        String sql = "SELECT contrasena, salt FROM persona WHERE usuario = ?";
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1, usuario);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                byte[] storedHash = resultSet.getBytes("contrasena");
                byte[] salt = resultSet.getBytes("salt");

                byte[] hashedInput = hashConSal(contrasena, salt);

                return Arrays.equals(storedHash, hashedInput);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private byte[] hashConSal(String contrasena, byte[] salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.update(salt);
            byte[] contrasenaBytes = contrasena.getBytes(StandardCharsets.UTF_8);
            byte[] hashedBytes = digest.digest(contrasenaBytes);
            return hashedBytes;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Persona> listarPersonas() {

        String sql = "SELECT * FROM persona";
        List<Persona> personas = new ArrayList<>();

        try (CallableStatement statement = cn.prepareCall(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int codPersona = resultSet.getInt("codPersona");
                String codigo = resultSet.getString("codigo");
                String nombre = resultSet.getString("nombre");
                String ap_pat = resultSet.getString("ap_pat");
                String ap_mat = resultSet.getString("ap_mat");
                int dni = resultSet.getInt("dni");
                java.sql.Date fechaContrato = resultSet.getDate("fechaContrato");
                int salario = resultSet.getInt("salario");
                String usuario = resultSet.getString("usuario");
                String contrasena = resultSet.getString("contrasena");
                byte[] salt = resultSet.getBytes("salt");
                String cargo = resultSet.getString("cargo");
                byte estado = resultSet.getByte("estado");

                Persona per = new Persona(codPersona, codigo, nombre, ap_pat, ap_mat, dni, fechaContrato, salario,
                        usuario, contrasena, salt, cargo, estado);
                personas.add(per);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personas;
    }
}
