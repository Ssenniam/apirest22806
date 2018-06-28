/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba9.controller;

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
import inacap.webcomponent.prueba9.model.AlumnoModel;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.prueba9.repository.AlumnoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author daniel
 */
@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    
    @Autowired
    private AlumnoRepository alumnoRepository;
    
    @GetMapping()
    public Iterable<AlumnoModel> listarTodos() {
        
        return alumnoRepository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoModel> muestraUnAlumno(@PathVariable String id) {
        
        Optional<AlumnoModel> aOptional = alumnoRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
          AlumnoModel aEncontrado = aOptional.get();
               return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoModel> editaAlumno(@PathVariable String id, @RequestBody AlumnoModel alumnoEditar) {
        
         Optional<AlumnoModel> aOptional = alumnoRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
          AlumnoModel aEncontrado = aOptional.get();
          
          alumnoEditar.setIdAlumno(aEncontrado.getIdAlumno());
          
          alumnoRepository.save(alumnoEditar);
          
               return new ResponseEntity<>(alumnoEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<?> agregarAlumno(@RequestBody AlumnoModel nuevoAlumno) {
        
       nuevoAlumno = alumnoRepository.save(nuevoAlumno);
        
        Optional<AlumnoModel> aOptional = alumnoRepository.findById(nuevoAlumno.getIdAlumno());
        
        if (aOptional.isPresent()) {
          AlumnoModel aEncontrado = aOptional.get();
               return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<AlumnoModel> aOptional = alumnoRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
          AlumnoModel aEncontrado = aOptional.get();
          
          alumnoRepository.deleteById(aEncontrado.getIdAlumno());
          
          return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }
    
}
