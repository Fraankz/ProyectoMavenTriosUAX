<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Gestión de Invitados</title>
</head>
<body>
<h2>Lista de Invitados</h2>
<form action="ServletGestionInvitados" method="post">
    <input type="text" name="nombre" placeholder="Nombre del Invitado" required>
    <button type="submit">Agregar</button>
</form>
</body>
</html>
