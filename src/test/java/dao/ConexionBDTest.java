package dao;

import Actividad.TDP.dao.ConexionBD;
import org.junit.jupiter.api.Test;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class TestConexionBD {
    @Test
    void testConexionExitosa() {
        try (Connection conexion = ConexionBD.obtenerConexion()) {
            assertNotNull(conexion, "La conexión no debe ser nula");
        } catch (Exception e) {
            fail("La conexión a la base de datos falló: " + e.getMessage());
        }
    }
}
