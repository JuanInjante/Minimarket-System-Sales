package Dao;

import Config.Connect_DB;
import Model.Proveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoProveedor {

    private Connection cn;

    public DaoProveedor() {
        Connect_DB connect_DB = new Connect_DB();
        this.cn = connect_DB.conectar();
    }

    public int insertarProveedor(String NombreEmpresa, String Nombre_Contacto, String Telefono) {

        String sql = "{CALL [dbo].[sp_insert_proveedor](?,?,?,?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {

            statement.setString(1, NombreEmpresa);
            statement.setString(2, Nombre_Contacto);
            statement.setString(3, Telefono);
            statement.setByte(4, (byte) 1);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("El proveedor se insertó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo insertar el proveedor");
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

    public int actualizarProveedor(Proveedor proveedor) {

        String sql = "{CALL [dbo].[sp_update_proveedor](?,?,?,?,?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {
            statement.setInt(1, proveedor.getCodProveedor());
            statement.setString(2, proveedor.getNombreEmpresa());
            statement.setString(3, proveedor.getNombre_contacto());
            statement.setString(4, proveedor.getTelefono());
            statement.setByte(5, proveedor.getEstado());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("El proveedor se actualizó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo actualizar el proveedor");
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

    public int eliminarProveedor(Proveedor proveedor) {
        String sql = "{CALL [dbo].[sp_delete_proveedor](?)}";

        try (CallableStatement statement = cn.prepareCall(sql)) {
            statement.setInt(1, proveedor.getCodProveedor());
            statement.execute();

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("El proveedor se eliminó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo eliminar el proveedor");
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

    public List<Proveedor> buscarProveedor(String nombreEmpresa, String nombre_contacto, Byte estado) {
        String sql = "{CALL [dbo].[sp_buscar_proveedor](?,?,?)}";

        try (CallableStatement statement = cn.prepareCall(sql)) {
            statement.setString(1, nombreEmpresa);
            statement.setString(2, nombre_contacto);

            if (estado != null) {

                statement.setByte(3, estado);
            } else {

                statement.setNull(3, java.sql.Types.TINYINT);
            }

            ResultSet resulset = statement.executeQuery();

            List<Proveedor> proveedores = new ArrayList<>();
            while (resulset.next()) {
                int codProveedor = resulset.getInt("codProveedor");
                String nombreEmpresaResultado = resulset.getString("nombreEmpresa");
                String nombreContactoResultado = resulset.getString("nombre_contacto");
                String telefonoResultado = resulset.getString("telefono");
                byte estadoResultado = resulset.getByte("estado");

                Proveedor proveedor1 = new Proveedor(codProveedor, nombreEmpresaResultado,
                        nombreContactoResultado, telefonoResultado, estadoResultado);
                proveedores.add(proveedor1);
            }
            return proveedores;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
