<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Invitados</title>
    <link rel="stylesheet" href="../css/style.css"> <!-- Enlace al nuevo archivo CSS -->
</head>
<body>
<div class="container">
    <h1>Gestión de Invitados</h1>

    <!-- Formulario para agregar invitados -->
    <form action="InvitadoServlet" method="post">
        <label for="nombre">Nombre del Invitado:</label>
        <input type="text" id="nombre" name="nombre" required>
        <button type="submit" name="accion" value="agregar">Agregar Invitado</button>
    </form>

    <!-- Formulario para eliminar invitados -->
    <form action="InvitadoServlet" method="post">
        <label for="id">ID del Invitado a Eliminar:</label>
        <input type="number" id="id" name="id" required>
        <button type="submit" name="accion" value="eliminar">Eliminar Invitado</button>
    </form>

    <!-- Lista de invitados -->
    <h2>Lista de Invitados</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
        </tr>
        <%
            java.util.List<Actividad.TDP.modelo.Invitado> invitados =
                    (java.util.List<Actividad.TDP.modelo.Invitado>) request.getAttribute("invitados");
            if (invitados != null) {
                for (Actividad.TDP.modelo.Invitado invitado : invitados) {
        %>
        <tr>
            <td><%= invitado.getId() %></td>
            <td><%= invitado.getNombre() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>
</div>
</body>
</html>
