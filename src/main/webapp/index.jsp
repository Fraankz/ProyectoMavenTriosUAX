<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Actividad.TDP.dao.InvitadoDAO" %>
<%@ page import="Actividad.TDP.modelo.Invitado" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Invitados</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; padding: 20px; }
        h2 { color: #333; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        table, th, td { border: 1px solid black; }
        th, td { padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
        form { margin-bottom: 20px; }
        button { padding: 10px; background-color: #28a745; color: white; border: none; cursor: pointer; }
        button:hover { background-color: #218838; }
    </style>
</head>
<body>

<h2>Gestión de Invitados</h2>

<!-- Formulario para Agregar Invitado -->
<h3>Agregar Invitado</h3>
<form action="InvitadoServlet" method="post">
    <input type="hidden" name="action" value="agregar">
    <label>Nombre:</label>
    <input type="text" name="nombre" required>
    <button type="submit">Agregar</button>
</form>

<!-- Formulario para Eliminar Invitado -->
<h3>Eliminar Invitado</h3>
<form action="InvitadoServlet" method="post">
    <input type="hidden" name="action" value="eliminar">
    <label>ID del Invitado:</label>
    <input type="number" name="id" required>
    <button type="submit" style="background-color: #dc3545;">Eliminar</button>
</form>

<!-- Mostrar la Lista de Invitados -->
<h3>Lista de Invitados</h3>
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
    <% } %>
</table>

</body>
</html>
