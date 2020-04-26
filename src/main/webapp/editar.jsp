<%-- 
    Document   : lista
    Created on : 19 abr. 2020, 18:35:03
    Author     : postgres
--%>

<%@page import="root.model.dao.PacPacienteDAO"%>
<%@page import="root.model.entities.PacPaciente"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
                        <%
                                PacPacienteDAO dao = new PacPacienteDAO();
                                PacPaciente pac = dao.findPacPaciente((String)request.getAttribute("rut"));                                
                        %>
                        <form name="form" action="buttonController" method="POST" id="formulario">
                                <div class="form-group">
                                        <label>Rut</label>
                                        <input type="text" class="form-control" name="rut" value="<%= pac.getPacRut() %>">
                                </div>

                                <div class="form-group">
                                        <label>Nombre</label>
                                        <input type="text" class="form-control" name="nombre" value="<%= pac.getPacNombre() %>">
                                </div> 

                                <div class="form-group">
                                        <label>Apellido</label>
                                        <input type="text" class="form-control" name="apellido" value="<%= pac.getPacApellido() %>">
                                </div>

                                <div class="form-group">
                                        <label>Edad</label>
                                        <input type="number" class="form-control" name="edad" value="<%= pac.getPacEdad() %>">
                                </div>
                                <div class="form-group">
                                        <label>Estado</label>
                                        <select class="custom-select" name="estado">
                                                <option value="" selected><%= pac.getPacEstado() %></option>
                                                <option value="Leve">Leve</option>
                                                <option value="Menos Grave">Menos Grave</option>
                                                <option value="Grave">Grave</option>
                                                <option value="Crítico">Crítico</option>
                                        </select>
                                </div>                               
                                
                                <input type="submit" name="accion" class="btn btn-success" value="Actualizar"/>
                                <input type="submit" name="accion" class="btn btn-dark" value="Cancelar"/>
                                
                        </form>
                </div>           
        </body>
</html>
