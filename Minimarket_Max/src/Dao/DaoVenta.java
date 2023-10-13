package Dao;

import Config.Connect_DB;
import Model.Venta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoVenta {

    private Connection cn;

    public DaoVenta() {
        Connect_DB connect_DB = new Connect_DB();
        this.cn = connect_DB.conectar();
    }

    public int insertarVenta(Venta venta) {

        String sql = "{CALL [dbo].[sp_insert_venta](?,?,?,?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {

            statement.setInt(1, venta.getCodCliente());
            statement.setString(2, venta.getCodigo_empleado());
            statement.setString(3, venta.getTipoComprobante());
            statement.setByte(4, venta.getEstado());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("La venta se insertó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo insertar la venta");
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

    public int eliminarProducto(Venta venta) {

        String sql = "{CALL [dbo].[sp_delete_venta](?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {
            statement.setInt(1, venta.getCodVenta());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("La venta se eliminó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo eliminar la venta");
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

    public List<Venta> buscarProductos(String tipoComprobante, Byte estado, String codigo_empleado) {

        String sql = "{CALL [dbo].[sp_buscar_venta](?,?)}";

        try (CallableStatement statement = cn.prepareCall(sql)) {

            statement.setString(1, tipoComprobante);
            statement.setString(2, codigo_empleado);

            if (estado != null) {

                statement.setByte(3, estado);
            } else {

                statement.setNull(3, java.sql.Types.TINYINT);
            }

            ResultSet resulset = statement.executeQuery();

            List<Venta> ventas = new ArrayList<>();
            while (resulset.next()) {
                int codVenta = resulset.getInt("codVenta");
                int codCliente = resulset.getInt("codCliente");
                String codigo_empleadoResultado = resulset.getString("codigo_empleado");
                java.sql.Date fecha_hora_ventaResultado = resulset.getDate("fecha_hora_venta");
                String tipoComprobanteResultado = resulset.getString("tipoComprobante");
                double totalResultado = resulset.getDouble("total");
                byte estadoResultado = resulset.getByte("estado");

                Venta vent = new Venta(codVenta, codCliente, codigo_empleadoResultado, fecha_hora_ventaResultado,
                        tipoComprobanteResultado, totalResultado, estadoResultado);
                ventas.add(vent);
            }
            return ventas;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}
