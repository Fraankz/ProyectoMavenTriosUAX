package modelo;

import Actividad.TDP.modelo.Invitado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestInvitado {
    @Test
    void testCrearInvitado() {
        Invitado invitado = new Invitado(1, "Carlos Gómez");
        assertEquals(1, invitado.getId(), "El ID debe ser 1");
        assertEquals("Carlos Gómez", invitado.getNombre(), "El nombre debe ser Carlos Gómez");
    }
}
