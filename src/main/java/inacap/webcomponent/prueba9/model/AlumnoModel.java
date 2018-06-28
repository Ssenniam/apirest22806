/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba9.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "alumno")
public class AlumnoModel {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlumno;
    
    private String nombreAlumno;
    
    private String apellidoAlumno;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_alumno")
    private TipoAlumnoModel tipoAlumno;
    

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }

    public TipoAlumnoModel getTipoAlumno() {
        return tipoAlumno;
    }

    public void setTipoAlumno(TipoAlumnoModel tipoAlumno) {
        this.tipoAlumno = tipoAlumno;
    }

    public AlumnoModel() {
    }

    public AlumnoModel(String nombreAlumno, String apellidoAlumno, TipoAlumnoModel tipoAlumno) {
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.tipoAlumno = tipoAlumno;
    }

    private AlumnoModel(int idAlumno, String nombreAlumno, String apellidoAlumno, TipoAlumnoModel tipoAlumno) {
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.tipoAlumno = tipoAlumno;
    }
    
    
    
   
    
    
    
    
}
