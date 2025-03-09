package Actividad.TDP.servicio;

import Actividad.TDP.dao.InvitadoDAO;
import Actividad.TDP.modelo.Invitado;

public class Servicio {
    private InvitadoDAO invitadoDAO;

    // Constructor sin parámetros (por si se usa en otro lado)
    public Servicio() {
        this.invitadoDAO = new InvitadoDAO();
    }

    // Constructor con `InvitadoDAO` (para pruebas)
    public Servicio(InvitadoDAO invitadoDAO) {
        this.invitadoDAO = invitadoDAO;
    }

    public boolean agregarInvitado(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        return invitadoDAO.insertarInvitado(new Invitado(0, nombre));
    }
}
