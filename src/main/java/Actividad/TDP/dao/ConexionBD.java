package Actividad.TDP.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://tu-servidor-mysql.com:3306/gestion_invitados";
    private static final String USUARIO = "usuario";
    private static final String PASSWORD = "contraseña";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}
