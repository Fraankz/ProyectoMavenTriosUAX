package Actividad.TDP.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Actividad.TDP.modelo.Invitado;

public class InvitadoDAO {
    private static final String URL = "jdbc:mysql://host:puerto/gestion_invitados";
    private static final String USER = "usuario";
    private static final String PASSWORD = "contraseña";

    public List<Invitado> obtenerTodos() throws SQLException {
        List<Invitado> invitados = new ArrayList<>();
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM invitados");

        while (rs.next()) {
            invitados.add(new Invitado(rs.getInt("id"), rs.getString("nombre")));
        }

        con.close();
        return invitados;
    }
}
