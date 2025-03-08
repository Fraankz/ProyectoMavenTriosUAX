package Actividad.TDP.servicio;

import Actividad.TDP.dao.InvitadoDAO;
import Actividad.TDP.modelo.Invitado;
import java.util.List;

public class Servicio {
    private final InvitadoDAO invitadoDAO;

    public Servicio() {
        this.invitadoDAO = new InvitadoDAO();
    }

    /**
     * Agrega un nuevo invitado a la base de datos.
     *
     * @param nombre Nombre del invitado a agregar.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    public boolean agregarInvitado(String nombre) {
        Invitado nuevoInvitado = new Invitado(nombre);
        return invitadoDAO.insertarInvitado(nuevoInvitado);
    }

    /**
     * Elimina un invitado de la base de datos dado su ID.
     *
     * @param id ID del invitado a eliminar.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    public boolean eliminarInvitado(int id) {
        return invitadoDAO.eliminarInvitado(id);
    }

    /**
     * Obtiene la lista de todos los invitados registrados en la base de datos.
     *
     * @return Lista de objetos Invitado.
     */
    public List<Invitado> obtenerInvitados() {
        return invitadoDAO.obtenerTodosLosInvitados();
    }
}
