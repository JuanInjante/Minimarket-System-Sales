package Dao;

import Config.Connect_DB;
import Model.Inventario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoInventario {

    private Connection cn;

    public DaoInventario() {
        Connect_DB connect_DB = new Connect_DB();
        this.cn = connect_DB.conectar();
    }

    public int insertarInventario(Inventario inventario) {

        String sql = "{CALL [dbo].[sp_insert_inventario](?,?,?,?,?,?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {

            statement.setInt(1, inventario.getCodProducto());
            statement.setInt(2, inventario.getCodPersona());
            statement.setInt(3, inventario.getStock());
            statement.setDate(4, new java.sql.Date(inventario.getFecha_hora_entrada().getTime()));
            statement.setDouble(5, inventario.getPrecioCompra());
            statement.setByte(6, inventario.getEstado());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("El producto se insertó correctamente al inventario");
                    return 1;
                } else {
                    System.out.println("No se pudo insertar el producto al inventario");
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

    public int actualizarInventario(Inventario inventario) {

        String sql = "{CALL [dbo].[sp_update_inventario](?,?,?}";
        try (CallableStatement statement = cn.prepareCall(sql)) {

            statement.setInt(1, inventario.getStock());
            statement.setDouble(2, inventario.getPrecioCompra());
            statement.setByte(3, inventario.getEstado());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("El inventario se actualizó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo actualizar el inventario");
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

    public int eliminarProducto(Inventario inventario) {

        String sql = "{CALL [dbo].[sp_delete_producto](?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {
            statement.setInt(1, inventario.getCodInventario());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("El producto se eliminó correctamente del inventario");
                    return 1;
                } else {
                    System.out.println("No se pudo eliminar el producto del inventario");
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

    public List<Inventario> buscarProductosEnElInventario(int codInvetario, int codProducto,
            int codPersona, Byte estado) {

        String sql = "{CALL [dbo].[sp_buscar_producto](?,?,?,?)}";

        try (CallableStatement statement = cn.prepareCall(sql)) {

            statement.setInt(1, codInvetario);
            statement.setInt(2, codProducto);
            statement.setInt(3, codPersona);

            if (estado != null) {

                statement.setByte(4, estado);
            } else {

                statement.setNull(4, java.sql.Types.TINYINT);
            }

            ResultSet resulset = statement.executeQuery();

            List<Inventario> inventarios = new ArrayList<>();
            while (resulset.next()) {
                int codInventarioResultado = resulset.getInt("codInventario");
                int codProductoResultado = resulset.getInt("codProducto");
                int codPersonaResultado = resulset.getInt("codPersona");
                int stock = resulset.getInt("stock");
                java.sql.Date fecha_hora_entrada = resulset.getDate("fecha_hora_entrada");
                int precioCompra = resulset.getInt("precioCompra");
                byte estadoResultado = resulset.getByte("estado");

                Inventario invent = new Inventario(codInventarioResultado, codProductoResultado, codPersonaResultado,
                        stock, fecha_hora_entrada, precioCompra, estadoResultado);
                inventarios.add(invent);
            }
            return inventarios;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}
