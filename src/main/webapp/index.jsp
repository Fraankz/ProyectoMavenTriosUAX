<%@ page import="Actividad.TDP.dao.InvitadoDAO" %>
<%@ page import="Actividad.TDP.modelo.Invitado" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Gestión de Invitados</title>
</head>
<body>
<h1>Gestión de Invitados</h1>

<h2>Agregar Invitado</h2>
<form action="InvitadoServlet" method="POST">
    <label for="nombre">Nombre del Invitado:</label>
    <input type="text" name="nombre" id="nombre" required>
    <input type="hidden" name="action" value="agregar">
    <button type="submit">Agregar Invitado</button>
</form>

<h2>Lista de Invitados</h2>
<table border="1">
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
</body>
</html>
