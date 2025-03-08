package Actividad.TDP.modelo;

public class Invitado {
    private int id;
    private String nombre;

    // Constructor vacío (necesario para algunos frameworks y serialización)
    public Invitado() {
    }

    // Constructor con nombre (para insertar nuevos invitados)
    public Invitado(String nombre) {
        this.nombre = nombre;
    }

    // Constructor con ID y nombre (para recuperar invitados de la BD)
    public Invitado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
