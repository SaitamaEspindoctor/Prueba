/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author postgres
 */
@Entity
@Table(name = "pac_paciente")
@NamedQueries({
        @NamedQuery(name = "PacPaciente.findAll", query = "SELECT p FROM PacPaciente p"),
        @NamedQuery(name = "PacPaciente.findByPacApellido", query = "SELECT p FROM PacPaciente p WHERE p.pacApellido = :pacApellido"),
        @NamedQuery(name = "PacPaciente.findByPacEdad", query = "SELECT p FROM PacPaciente p WHERE p.pacEdad = :pacEdad"),
        @NamedQuery(name = "PacPaciente.findByPacNombre", query = "SELECT p FROM PacPaciente p WHERE p.pacNombre = :pacNombre"),
        @NamedQuery(name = "PacPaciente.findByPacRut", query = "SELECT p FROM PacPaciente p WHERE p.pacRut = :pacRut"),
        @NamedQuery(name = "PacPaciente.findByPacEstado", query = "SELECT p FROM PacPaciente p WHERE p.pacEstado = :pacEstado")})
public class PacPaciente implements Serializable {

        private static final long serialVersionUID = 1L;
        @Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 15)
        @Column(name = "pac_Apellido")
        private String pacApellido;
        @Basic(optional = false)
        @NotNull
        @Column(name = "pac_Edad")
        private int pacEdad;
        @Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 15)
        @Column(name = "pac_Nombre")
        private String pacNombre;
        @Id
        @Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 10)
        @Column(name = "pac_Rut")
        private String pacRut;
        @Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 2147483647)
        @Column(name = "pac_Estado")
        private String pacEstado;

        public PacPaciente() {
        }

        public PacPaciente(String pacRut) {
                this.pacRut = pacRut;
        }

        public PacPaciente(String pacRut, String pacApellido, int pacEdad, String pacNombre, String pacEstado) {
                this.pacRut = pacRut;
                this.pacApellido = pacApellido;
                this.pacEdad = pacEdad;
                this.pacNombre = pacNombre;
                this.pacEstado = pacEstado;
        }

        public String getPacApellido() {
                return pacApellido;
        }

        public void setPacApellido(String pacApellido) {
                this.pacApellido = pacApellido;
        }

        public int getPacEdad() {
                return pacEdad;
        }

        public void setPacEdad(int pacEdad) {
                this.pacEdad = pacEdad;
        }

        public String getPacNombre() {
                return pacNombre;
        }

        public void setPacNombre(String pacNombre) {
                this.pacNombre = pacNombre;
        }

        public String getPacRut() {
                return pacRut;
        }

        public void setPacRut(String pacRut) {
                this.pacRut = pacRut;
        }

        public String getPacEstado() {
                return pacEstado;
        }

        public void setPacEstado(String pacEstado) {
                this.pacEstado = pacEstado;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (pacRut != null ? pacRut.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof PacPaciente)) {
                        return false;
                }
                PacPaciente other = (PacPaciente) object;
                if ((this.pacRut == null && other.pacRut != null) || (this.pacRut != null && !this.pacRut.equals(other.pacRut))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "root.model.entities.PacPaciente[ pacRut=" + pacRut + " ]";
        }
        
}

