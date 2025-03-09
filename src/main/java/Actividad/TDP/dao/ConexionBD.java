package Actividad.TDP.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://shortline.proxy.rlwy.net:51833/railway?autoReconnect=true&useSSL=false";
    private static final String USUARIO = "root";  // O el que tengas en Railway
    private static final String PASSWORD = "duaFeWazsTctgAzZQjgJFxCcsPsCkhSj";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}
