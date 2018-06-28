/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba9.repository;

import org.springframework.data.repository.CrudRepository;
import inacap.webcomponent.prueba9.model.TipoAlumnoModel;

/**
 *
 * @author daniel
 */
public interface TipoAlumnoRepository extends CrudRepository<TipoAlumnoModel, Integer> {
    
}
