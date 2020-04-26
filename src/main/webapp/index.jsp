<%-- 
    Document   : index
    Created on : 19 abr. 2020, 16:15:56
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
                <form name="form" action="buttonController" method="POST">
                        <div class="container">
                                <button type="submit" name="accion" value="lista" class="btn btn-primary btn-lg btn-block">Ver Lista Completa</button>
                        </div>
                </form>
        </body>
</html>
