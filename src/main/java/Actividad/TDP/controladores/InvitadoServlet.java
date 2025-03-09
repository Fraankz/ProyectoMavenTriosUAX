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

            // Depuración para ver si el nombre se recibe
            System.out.println("Nombre recibido en el servlet: " + nombre);

            if (nombre != null && !nombre.trim().isEmpty()) {
                Invitado nuevoInvitado = new Invitado(0, nombre);
                boolean insertado = dao.insertarInvitado(nuevoInvitado);

                if (insertado) {
                    System.out.println("Invitado insertado correctamente en la base de datos.");
                } else {
                    System.out.println("Error al insertar el invitado en la base de datos.");
                }
            } else {
                System.out.println("⚠ El nombre del invitado está vacío o es nulo.");
            }
        } else if ("eliminar".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.eliminarInvitado(id);
            } catch (NumberFormatException e) {
                System.out.println("⚠ Error al convertir el ID para eliminar.");
            }
        }

        response.sendRedirect("index.jsp"); // Redirige de nuevo a la página principal
    }
}
