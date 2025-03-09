package dao;

import Actividad.TDP.dao.InvitadoDAO;
import Actividad.TDP.modelo.Invitado;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestInvitadoDAO {
    private final InvitadoDAO dao = new InvitadoDAO();

    @Test
    void testInsertarInvitado() {
        Invitado invitado = new Invitado(0, "Prueba Nombre");
        assertTrue(dao.insertarInvitado(invitado), "El invitado debería insertarse correctamente");
    }

    @Test
    void testObtenerTodosLosInvitados() {
        List<Invitado> lista = dao.obtenerTodosLosInvitados();
        assertNotNull(lista, "La lista de invitados no debe ser nula");
    }
}
