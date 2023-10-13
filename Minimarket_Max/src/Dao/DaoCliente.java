package Dao;

import Config.Connect_DB;
import Model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCliente {

    private Connection cn;

    public DaoCliente() {
        Connect_DB connect_DB = new Connect_DB();
        this.cn = connect_DB.conectar();
    }

    public int insertarCliente(String Nombre, String Ap_pat, String Ap_mat, int DNI, int Telefono,
            String Direccion, String Correo, String Genero) {

        String sql = "{CALL [dbo].[sp_insert_cliente](?,?,?,?,?,?,?,?,?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {

            statement.setString(1, Nombre);
            statement.setString(2, Ap_pat);
            statement.setString(3, Ap_mat);
            statement.setInt(4, DNI);
            statement.setInt(5, Telefono);
            statement.setString(6, Direccion);
            statement.setString(7, Correo);
            statement.setString(8, Genero);
            statement.setByte(9, (byte) 1);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("El cliente se insertó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo insertar el cliente");
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

    public int actualizarCliente(Cliente cliente) {

        String sql = "{CALL [dbo].[sp_update_cliente](?,?,?,?,?,?,?,?,?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getAp_pat());
            statement.setString(3, cliente.getAp_mat());
            statement.setInt(4, cliente.getDni());
            statement.setString(5, cliente.getTelefono());
            statement.setString(6, cliente.getDireccion());
            statement.setString(7, cliente.getCorreo_electronico());
            statement.setString(8, cliente.getGenero());
            statement.setByte(9, cliente.getEstado());
            statement.execute();

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("El cliente se insertó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo insertar el cliente");
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

    public int eliminarCliente(Cliente cliente) {

        String sql = "{CALL [dbo].[sp_delete_cliente](?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {
            statement.setInt(1, cliente.getCodCliente());
            statement.execute();

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("El cliente se insertó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo insertar el cliente");
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

    public List<Cliente> buscarClientes(String nombre, String ap_pat, String ap_mat,
            int dni, String genero, Byte estado) {

        String sql = "{CALL [dbo].[sp_buscar_cliente](?,?,?,?,?,?)}";

        try (CallableStatement statement = cn.prepareCall(sql)) {

            statement.setString(1, nombre);
            statement.setString(2, ap_pat);
            statement.setString(3, ap_mat);
            statement.setInt(4, dni);
            statement.setString(5, genero);

            if (estado != null) {

                statement.setByte(6, estado);
            } else {

                statement.setNull(6, java.sql.Types.TINYINT);
            }

            ResultSet resulset = statement.executeQuery();

            List<Cliente> clientes = new ArrayList<>();
            while (resulset.next()) {
                int codCliente = resulset.getInt("codCliente");
                String nombreResultado = resulset.getString("nombre");
                String ap_patResultado = resulset.getString("ap_pat");
                String ap_matResultado = resulset.getString("ap_mat");
                int dniResultado = resulset.getInt("dni");
                String telefonoResultado = resulset.getString("telefono");
                String direccionResultado = resulset.getString("direccion");
                String correo_electronicoResultado = resulset.getString("correo_electronico");
                String generoResultado = resulset.getString("genero");
                byte estadoResultado = resulset.getByte("estado");

                Cliente client = new Cliente(codCliente, nombreResultado, ap_patResultado,
                        ap_matResultado, dniResultado, telefonoResultado, direccionResultado,
                        correo_electronicoResultado, generoResultado, estadoResultado);
                clientes.add(client);
            }
            return clientes;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}
