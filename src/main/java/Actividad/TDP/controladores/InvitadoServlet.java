package Actividad.TDP.controladores;

import Actividad.TDP.dao.InvitadoDAO;
import Actividad.TDP.modelo.Invitado;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class InvitadoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InvitadoDAO dao = new InvitadoDAO();
        List<Invitado> invitados = null;
        try {
            invitados = dao.obtenerTodos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("invitados", invitados);
        request.getRequestDispatcher("/jsp/consulta.jsp").forward(request, response);
    }
}
