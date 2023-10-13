package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect_DB {

    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private String url = "jdbc:sqlserver://localhost:1433;databaseName=dbMinimarket;encrypt=true;trustServerCertificate=true";

    private String user = "MinimarketDB";

    private String pass = "minimarketMAX"; 

    public Connect_DB() {

    }

    public Connection conectar() {
        Connection cn = null;

        try {

            Class.forName(driver);

            cn = (DriverManager.getConnection(url, user, pass));
            System.out.println("conectado");

        } catch (ClassNotFoundException | SQLException e) {

            System.out.println("error en la conexion");

        }
        return cn;
    }

    public void CerrarConexion(Connection con) {

        try {

            con.close();
            System.out.println("cierre de conexion");
        } catch (Exception e) {
            
        }
    }
}
