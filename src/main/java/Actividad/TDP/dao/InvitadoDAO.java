package Actividad.TDP.dao;

import Actividad.TDP.modelo.Invitado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvitadoDAO {

    public boolean insertarInvitado(Invitado invitado) {
        String sql = "INSERT INTO invitados (nombre) VALUES (?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, invitado.getNombre());

            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Invitado insertado correctamente: " + invitado.getNombre());
                return true;
            } else {
                System.out.println("No se insertó ningún invitado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("⚠ Error SQL al insertar el invitado: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Invitado> obtenerTodosLosInvitados() {
        List<Invitado> invitados = new ArrayList<>();
        String sql = "SELECT * FROM invitados";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                invitados.add(new Invitado(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre")
                ));
            }
        } catch (SQLException e) {
            System.out.println("⚠ Error al obtener la lista de invitados: " + e.getMessage());
            e.printStackTrace();
        }
        return invitados;
    }

    public boolean eliminarInvitado(int id) {
        String sql = "DELETE FROM invitados WHERE id = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);

            int filasEliminadas = statement.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            System.out.println("⚠ Error SQL al eliminar el invitado: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}