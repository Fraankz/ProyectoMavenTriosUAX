package controladores;

import Actividad.TDP.controladores.InvitadoServlet;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TestInvitadoServlet {
    @Test
    void testAgregarInvitado() throws Exception {
        InvitadoServlet servlet = new InvitadoServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(request.getParameter("action")).thenReturn("agregar");
        when(request.getParameter("nombre")).thenReturn("Juan Pérez");
        when(response.getWriter()).thenReturn(writer);

        servlet.doPost(request, response);

        writer.flush();
        assertTrue(stringWriter.toString().contains("Invitado insertado correctamente"));
    }
}
