package Actividad.TDP.controladores;

import Actividad.TDP.dao.InvitadoDAO;
import Actividad.TDP.modelo.Invitado;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/InvitadoServlet")
public class InvitadoServlet extends HttpServlet {
    private InvitadoDAO dao = new InvitadoDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("agregar".equals(action)) {
            String nombre = request.getParameter("nombre");
            dao.insertarInvitado(new Invitado(nombre));
        } else if ("eliminar".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminarInvitado(id);
        }

        response.sendRedirect("index.jsp"); // Redirige de nuevo a la página principal
    }
}
