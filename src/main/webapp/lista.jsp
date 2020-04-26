<%-- 
    Document   : lista
    Created on : 19 abr. 2020, 18:35:03
    Author     : postgres
--%>

<%@page import="root.model.entities.PacPaciente"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
        List<PacPaciente> pacientes = (List<PacPaciente>) request.getSession().getAttribute("pacientes");
        Iterator<PacPaciente> itPacientes = pacientes.iterator();
%>

<html lang="es">
        <head>
                <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                <title>Evaluación 2</title>
        </head>
        <body background="https://slidesgo.com/storage/76837/0-covid-19.png" style="background-repeat: no-repeat; background-size: cover;">     
                <nav class="navbar navbar-dark bg-dark justify-content-center">
                        <span class="text-justify" style="color: #ffffff " >Pacientes COVID-19</span>
                </nav><br>        
                <div class="container">
                        <table class="table table-striped table-dark">
                                <thead>
                                        <tr>
                                                <th scope="col">RUT</th>
                                                <th scope="col">Nombre</th>
                                                <th scope="col">Apellido</th>
                                                <th scope="col">Edad</th>
                                                <th scope="col">Estado</th>
                                        </tr>
                                </thead>                 
                                <tbody> 
                                        <%
                                                while (itPacientes.hasNext()) {
                                                        PacPaciente pac = itPacientes.next();
                                        %> 
                                        <tr>
                                                <th scope="row"><%= pac.getPacRut()%></th>
                                                <td><%= pac.getPacNombre()%></td>
                                                <td><%= pac.getPacApellido()%></td>
                                                <td><%= pac.getPacEdad()%></td>
                                                <td><%= pac.getPacEstado()%></td>
                                                <td><a href="buttonController?accion=editar&rut=<%= pac.getPacRut()%>" class="btn btn-outline-warning" role="button">Editar</a></td>
                                                <td><a href="buttonController?accion=eliminar&rut=<%= pac.getPacRut()%>" class="btn btn-outline-danger" role="button">Eliminar</a></td>
                                        </tr>
                                        <%}%>
                                </tbody>
                        </table>
                        <form name="form" action="buttonController" method="POST">
                                <button type="submit" name="accion" value="agregar" class="btn btn-primary btn-lg btn-block">Agregar</button><br>
                        </form>
                        <a href="index.jsp" class="btn btn-secondary btn-lg btn-block" role="button">Volver</a>
                </div>       
        </body>
</html>
