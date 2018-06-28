/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba9.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 *
 * @author daniel
 */
@Entity
@Table(name = "tipo_alumno")
public class TipoAlumnoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoAlumno;
    
    private String nombreTipoAlumno;

    public int getIdTipoAlumno() {
        return idTipoAlumno;
    }

    public void setIdTipoAlumno(int idTipoAlumno) {
        this.idTipoAlumno = idTipoAlumno;
    }

    public String getNombreTipoAlumno() {
        return nombreTipoAlumno;
    }

    public void setNombreTipoAlumno(String nombreTipoAlumno) {
        this.nombreTipoAlumno = nombreTipoAlumno;
    }

    public TipoAlumnoModel() {
    }

    public TipoAlumnoModel(String nombreTipoAlumno) {
        this.nombreTipoAlumno = nombreTipoAlumno;
    }

    private TipoAlumnoModel(int idTipoAlumno, String nombreTipoAlumno) {
        this.idTipoAlumno = idTipoAlumno;
        this.nombreTipoAlumno = nombreTipoAlumno;
    }
    
    
    
    
}
