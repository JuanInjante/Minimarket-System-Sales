package Dao;

import Config.Connect_DB;
import Model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCategoria {

    private Connection cn;

    public DaoCategoria() {
        Connect_DB connect_DB = new Connect_DB();
        this.cn = connect_DB.conectar();
    }

    public int insertarCategoria(String Nombre) {

        String sql = "{CALL [dbo].[sp_insert_categoria](?,?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {

            statement.setString(1, Nombre);
            statement.setByte(2, (byte) 1);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("La categoria se insertó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo insertar la categoria");
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

    public int actualizarCategoria(Categoria categoria) {

        String sql = "{CALL [dbo].[sp_update_categoria](?,?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {
            statement.setInt(1, categoria.getCodCategoria());
            statement.setString(2, categoria.getNombre());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int estado = resultSet.getInt("Estado");
                String mensaje = resultSet.getString("Mensaje");

                System.out.println("Estado: " + estado);
                System.out.println("Mensaje: " + mensaje);

                if (estado == 1) {
                    System.out.println("La categoria se actualizó correctamente");
                    return 1;
                } else {
                    System.out.println("No se pudo actualizar la categoria");
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

    public int eliminarCategoria(Categoria categoria) {

        String sql = "{CALL [dbo].[sp_delete_categoria](?)}";
        try (CallableStatement statement = cn.prepareCall(sql)) {
            statement.setInt(1, categoria.getCodCategoria());
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

    public List<Categoria> buscarCategoria(String nombre, Byte estado) {
        String sql = "{CALL [dbo].[sp_buscar_categoria](?,?)}";

        try (CallableStatement statement = cn.prepareCall(sql)) {

            statement.setString(1, nombre);

            if (estado != null) {

                statement.setByte(2, estado);
            } else {

                statement.setNull(2, java.sql.Types.TINYINT);
            }

            ResultSet resulset = statement.executeQuery();

            List<Categoria> categorias = new ArrayList<>();
            while (resulset.next()) {
                int codCategoria = resulset.getInt("codCategoria");
                String nombreResultado = resulset.getString("nombre");
                byte estadoResultado = resulset.getByte("estado");

                Categoria cat = new Categoria(codCategoria, nombreResultado, estadoResultado);
                categorias.add(cat);
            }
            return categorias;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}
