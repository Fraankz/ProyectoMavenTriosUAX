<%@ page import="Actividad.TDP.dao.InvitadoDAO" %>
<%@ page import="Actividad.TDP.modelo.Invitado" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Gestión de Invitados</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
    <h1>Gestión de Invitados</h1>

    <h2>Agregar Invitado</h2>
    <form action="InvitadoServlet" method="POST">
        <label for="nombre">Nombre del Invitado:</label>
        <input type="text" name="nombre" id="nombre" required>
        <input type="hidden" name="action" value="agregar">
        <button type="submit" class="btn agregar">Agregar Invitado</button>
    </form>

    <h2>Eliminar Invitado</h2>
    <form action="InvitadoServlet" method="POST">
        <label for="id">ID del Invitado a Eliminar:</label>
        <input type="text" name="id" id="id" required>
        <input type="hidden" name="action" value="eliminar">
        <button type="submit" class="btn eliminar">Eliminar Invitado</button>
    </form>

    <h2>Lista de Invitados</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
        </tr>
        <%
            InvitadoDAO dao = new InvitadoDAO();
            List<Invitado> invitados = dao.obtenerTodosLosInvitados();
            for (Invitado invitado : invitados) {
        %>
        <tr>
            <td><%= invitado.getId() %></td>
            <td><%= invitado.getNombre() %></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>