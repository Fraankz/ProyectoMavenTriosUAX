package servicio;

import Actividad.TDP.dao.InvitadoDAO;
import Actividad.TDP.modelo.Invitado;
import Actividad.TDP.servicio.Servicio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServicioTest {

    @Spy
    private InvitadoDAO daoSpy = new InvitadoDAO(); // Usa Spy en lugar de Mock

    @InjectMocks
    private Servicio servicio;

    @Test
    void testAgregarInvitado() {
        Invitado invitado = new Invitado(0, "Test Usuario");
        doReturn(true).when(daoSpy).insertarInvitado(any(Invitado.class));

        assertTrue(servicio.agregarInvitado("Test Usuario"), "El invitado debería insertarse correctamente");
    }
}

