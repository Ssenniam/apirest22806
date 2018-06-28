/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba9.controller;

import inacap.webcomponent.prueba9.model.AlumnoModel;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import inacap.webcomponent.prueba9.repository.TipoAlumnoRepository;
import inacap.webcomponent.prueba9.model.TipoAlumnoModel;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author daniel
 */
@RestController
@RequestMapping("/tipoAlumno")
public class TipoAlumnoController {
    
    @Autowired
    private TipoAlumnoRepository tipoAlumnoRepository;
    
    @GetMapping()
    public Iterable<TipoAlumnoModel> list() {
        return tipoAlumnoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TipoAlumnoModel> get(@PathVariable String id) {
        
        Optional<TipoAlumnoModel> taOptional = tipoAlumnoRepository.findById(Integer.parseInt(id));
        
        if (taOptional.isPresent()) {
          TipoAlumnoModel taEncontrado = taOptional.get();
               return new ResponseEntity<>(taEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoAlumnoModel> put(@PathVariable String id, @RequestBody TipoAlumnoModel tipoAlumnoEditar) {
        
        Optional<TipoAlumnoModel> taOptional = tipoAlumnoRepository.findById(Integer.parseInt(id));
        
        if (taOptional.isPresent()) {
          TipoAlumnoModel taEncontrado = taOptional.get();
          
          tipoAlumnoEditar.setIdTipoAlumno(taEncontrado.getIdTipoAlumno());
          
          tipoAlumnoRepository.save(tipoAlumnoEditar);
          return new ResponseEntity<>(tipoAlumnoEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoAlumnoModel tipoAlumnoNuevo) {
        tipoAlumnoNuevo = tipoAlumnoRepository.save(tipoAlumnoNuevo);
        
        
        Optional<TipoAlumnoModel> taOptional = tipoAlumnoRepository.findById(tipoAlumnoNuevo.getIdTipoAlumno());
        
        if (taOptional.isPresent()) {
          TipoAlumnoModel taEncontrado = taOptional.get();
               return new ResponseEntity<>(taEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<TipoAlumnoModel> taOptional = tipoAlumnoRepository.findById(Integer.parseInt(id));
        
        if (taOptional.isPresent()) {
          TipoAlumnoModel taEncontrado = taOptional.get();
          
          tipoAlumnoRepository.deleteById(taEncontrado.getIdTipoAlumno());
               return new ResponseEntity<>(taEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
}
