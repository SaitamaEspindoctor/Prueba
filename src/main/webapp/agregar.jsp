<%-- 
    Document   : agregar
    Created on : 20 abr. 2020, 8:22:33
    Author     : postgres
--%>

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
                        <form name="form" action="buttonController" method="POST" id="formulario">
                                <div class="form-group">
                                        <label>Rut</label>
                                        <input type="text" placeholder="12345678-9 Recuerda agregar el guión" class="form-control" name="rut" >
                                </div>

                                <div class="form-group">
                                        <label>Nombre</label>
                                        <input type="text" class="form-control" name="nombre" >
                                </div> 

                                <div class="form-group">
                                        <label>Apellido</label>
                                        <input type="text" class="form-control" name="apellido" >
                                </div>

                                <div class="form-group">
                                        <label>Edad</label>
                                        <input type="number" class="form-control" name="edad" >
                                </div>
                                <div class="form-group">
                                        <label>Estado</label>
                                        <select class="custom-select" name="estado">
                                                <option value="" selected>Seleccione Estado del Paciente</option>
                                                <option value="Leve">Leve</option>
                                                <option value="Menos Grave">Menos Grave</option>
                                                <option value="Grave">Grave</option>
                                                <option value="Crítico">Crítico</option>
                                        </select>
                                </div>                               
                                
                                <input type="submit" name="accion" class="btn btn-success" value="Guardar"/>
                                <input type="submit" name="accion" class="btn btn-dark" value="Cancelar"/>
                                
                        </form>
                </div>       
        </body>
</html>
