package Actividad.TDP.dao;

import Actividad.TDP.modelo.Invitado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvitadoDAO {

    public boolean insertarInvitado(Invitado invitado) {
        String sql = "INSERT INTO invitados (nombre) VALUES (?)";
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, invitado.getNombre());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarInvitado(int id) {
        String sql = "DELETE FROM invitados WHERE id = ?";
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Invitado> obtenerTodosLosInvitados() {
        List<Invitado> listaInvitados = new ArrayList<>();
        String sql = "SELECT * FROM invitados";
        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement statement = conexion.createStatement();
             ResultSet resultado = statement.executeQuery(sql)) {
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                listaInvitados.add(new Invitado(id, nombre));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaInvitados;
    }
}
