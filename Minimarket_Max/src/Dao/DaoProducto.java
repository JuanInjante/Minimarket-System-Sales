package Dao;

import Config.Connect_DB;
import Model.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoProducto {

    private Connection cn;

    public DaoProducto() {
        Connect_DB connect_DB = new Connect_DB();
        this.cn = connect_DB.conectar();
    }

    public int insertarProducto(int codProveedor, int codCategoria, String nombre, String descripcion,
            String fecha_vencimiento, String unidadMedida) {

        String sql = "{CALL [dbo].[sp_insert_producto](?,?,?,?,?,?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {

            statement.setInt(1, codProveedor);
            statement.setInt(2, codCategoria);
            statement.setString(3, nombre);
            statement.setString(4, descripcion);
            statement.setString(5, fecha_vencimiento);
            statement.setString(6, unidadMedida);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("El producto se insertó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo insertar el producto");
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

    public int actualizarProducto(Producto producto) {

        String sql = "{CALL [dbo].[sp_update_producto](?,?,?,?,?,?,?,?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {
            statement.setInt(1, producto.getCodProducto());
            statement.setInt(2, producto.getCodProveedor());
            statement.setInt(3, producto.getCodCategoria());    
            statement.setString(4, producto.getNombre());
            statement.setString(5, producto.getDescripcion());
            statement.setDate(6, new java.sql.Date(producto.getFecha_vencimiento().getTime()));
            statement.setString(7, producto.getUnidadMedida());
            statement.setByte(8, producto.getEstado());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("El producto se actualizó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo actualizar el producto");
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

    public int eliminarProducto(Producto producto) {

        String sql = "{CALL [dbo].[sp_delete_producto](?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {
            statement.setInt(1, producto.getCodProducto());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("El producto se eliminó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo eliminar el producto");
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

        public List<Producto> buscarProductos(String nombre, Byte estado) {

            String sql = "{CALL [dbo].[sp_buscar_producto](?,?)}";

            try (CallableStatement statement = cn.prepareCall(sql)) {

                statement.setString(1, nombre);

                if (estado != null) {

                    statement.setByte(2, estado);
                } else {

                    statement.setNull(2, java.sql.Types.TINYINT);
                }

                ResultSet resulset = statement.executeQuery();

                List<Producto> productos = new ArrayList<>();
                while (resulset.next()) {
                    int codProducto = resulset.getInt("codProducto");
                    int codProveedor = resulset.getInt("codProveedor");
                    int codCategoria = resulset.getInt("codCategoria");
                    String nombreResultado = resulset.getString("nombre");
                    String descripcionResultado = resulset.getString("descripcion");
                    java.sql.Date fecha_vencimientoResultado = resulset.getDate("fecha_vencimiento");
                    java.sql.Date fecha_creacionResultado = resulset.getDate("fecha_creacion");
                    java.sql.Date fecha_modificacionResultado = resulset.getDate("fecha_modificacion");
                    String unidadMedidaResultado = resulset.getString("unidadMedida");
                    byte estadoResultado = resulset.getByte("estado");

                    Producto product = new Producto(codProducto,codProveedor, codCategoria, nombreResultado, descripcionResultado,
                            fecha_vencimientoResultado, fecha_creacionResultado, fecha_modificacionResultado, unidadMedidaResultado,
                            estadoResultado);
                    productos.add(product);
                }
                return productos;
            } catch (Exception e) {

                e.printStackTrace();
                return null;
            }
        }

    public List<Producto> listarProductos() {

        String sql = "SELECT * FROM producto";
        List<Producto> productos = new ArrayList<>();

        try (CallableStatement statement = cn.prepareCall(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int codProducto = resultSet.getInt("codProducto");
                int codProveedor = resultSet.getInt("codProveedor");
                int codCategoria = resultSet.getInt("codCategoria");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                java.sql.Date fecha_vencimiento = resultSet.getDate("fecha_vencimiento");
                java.sql.Date fecha_creacion = resultSet.getDate("fecha_creacion");
                java.sql.Date fecha_modificacion = resultSet.getDate("fecha_modificacion");
                String unidadMedida = resultSet.getString("unidadMedida");
                byte estado = resultSet.getByte("estado");

                Producto producto = new Producto(codProducto, codProveedor, codCategoria, nombre, descripcion, fecha_vencimiento, fecha_creacion, fecha_modificacion, unidadMedida, estado);
                productos.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productos;
    }
}
