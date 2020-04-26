/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import root.model.dao.PacPacienteDAO;
import root.model.entities.PacPaciente;

/**
 *
 * @author postgres
 */
@WebServlet(name = "ButtonController", urlPatterns = {"/buttonController"})
public class ButtonController extends HttpServlet {

        /**
         * Processes requests for both HTTP <code>GET</code> and
         * <code>POST</code> methods.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException, Exception {

                //Creación de objetos Entity y DAO para su reutilización en cada Case
                String accion = request.getParameter("accion");
                PacPacienteDAO dao = new PacPacienteDAO();
                PacPaciente paciente = new PacPaciente();
                //Obtencion de datos
                String rut = request.getParameter("rut");
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String edad = request.getParameter("edad");
                String estado = request.getParameter("estado");

                switch (accion) {
                        case "lista":

                                List<PacPaciente> pacientes = dao.findPacPacienteEntities();
                                request.getSession().setAttribute("pacientes", pacientes);
                                request.getRequestDispatcher("lista.jsp").forward(request, response);
                                break;
                        case "agregar":
                                request.getRequestDispatcher("agregar.jsp").forward(request, response);
                                break;
                        case "Guardar":
                                //validación de campos vacíos o con espacios
                                if (rut.trim().equals("") || nombre.trim().equals("") || apellido.trim().equals("") || edad.trim().equals("") || estado.trim().equals("")) {
                                        request.getRequestDispatcher("error.jsp").forward(request, response);

                                } else {
                                        //Parseo de campo edad seteo de datos en la Entidad y creación del paciente mediante DAO
                                        int ed = Integer.parseInt(edad);
                                        paciente.setPacRut(rut);
                                        paciente.setPacNombre(nombre);
                                        paciente.setPacApellido(apellido);
                                        paciente.setPacEdad(ed);
                                        paciente.setPacEstado(estado);
                                        dao.create(paciente);
                                        //Se reenvia a case Lista para mostrar por pantalla a todos los pacientes
                                        request.getRequestDispatcher("buttonController?accion=lista").forward(request, response);
                                        break;
                                }
                        case "Cancelar":
                                request.getRequestDispatcher("lista.jsp").forward(request, response);
                                break;
                        case "editar":
                                request.setAttribute("rut", rut);
                                request.getRequestDispatcher("editar.jsp").forward(request, response);
                                break;
                        case "Actualizar":
                                //Parseo de campo edad seteo de datos en la Entidad y creación del paciente mediante DAO
                                int ed = Integer.parseInt(edad);
                                paciente.setPacRut(rut);
                                paciente.setPacNombre(nombre);
                                paciente.setPacApellido(apellido);
                                paciente.setPacEdad(ed);
                                paciente.setPacEstado(estado);
                                dao.edit(paciente);
                                //Se reenvia a case Lista para mostrar por pantalla a todos los pacientes
                                request.getRequestDispatcher("buttonController?accion=lista").forward(request, response);
                                break;
                        case "eliminar":
                                // Seteamos solo el rut y luego se elimina con metodo "destroy" por medio del DAO
                                paciente.setPacRut(rut);
                                dao.destroy(rut);
                                //Se reenvia a case Lista para mostrar por pantalla a todos los pacientes y verificar la eliminacion
                                request.getRequestDispatcher("buttonController?accion=lista").forward(request, response);
                                break;
                }
        }

        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Handles the HTTP <code>GET</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                try {
                        processRequest(request, response);
                } catch (Exception ex) {
                        Logger.getLogger(ButtonController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                try {
                        processRequest(request, response);
                } catch (Exception ex) {
                        Logger.getLogger(ButtonController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo() {
                return "Short description";
        }// </editor-fold>

}


