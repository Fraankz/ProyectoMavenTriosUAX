package Actividad.TDP.controladores;

import Actividad.TDP.dao.InvitadoDAO;
import Actividad.TDP.modelo.Invitado;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


@WebServlet("/invitado")
public class InvitadoServlet extends HttpServlet {
    protected void doGet(@org.jetbrains.annotations.NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InvitadoDAO dao = new InvitadoDAO();
        List<Invitado> invitados = dao.obtenerTodosLosInvitados(); // Eliminamos el try-catch innecesario

        request.setAttribute("invitados", invitados);
        request.getRequestDispatcher("/jsp/consulta.jsp").forward(request, response);
    }
}
