/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.controladores;

import com.skynet.api.modelos.supervisor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.skynet.api.servicios.supervisorServicioImplementado;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Enmanuel
 */

@RestController
@RequestMapping("/api")
public class supervisorControlador {
    
    @Autowired
    supervisorServicioImplementado supervisorServicio;
    
    
    @GetMapping("/supervisor")
    public List<supervisor> selectClientes(){
        
        return supervisorServicio.selectAll();
    }
    
    @GetMapping("supervisores/{Nombre}")
    public List<supervisor> selectFiltrado(@PathVariable String Nombre){
        
        return supervisorServicio.selectFiltrado(Nombre);
    }
    @GetMapping("supervisor/{Codigo}/{Codigo2}")
    public ResponseEntity<supervisor> selectIntro(@PathVariable String Codigo,@PathVariable String Codigo2){
       supervisor usuarioId = supervisorServicio.selectCod2(Codigo,Codigo2);
       return ResponseEntity.ok(usuarioId);
    }
    @PostMapping("supervisor")
    public ResponseEntity<supervisor> insertCliente(@RequestBody supervisor Supervisor){
        supervisor nueva = supervisorServicio.insert(Supervisor);
        return new ResponseEntity<>(nueva,HttpStatus.CREATED);
    }
    
     @GetMapping("supervisor/{Codigo}")
    public ResponseEntity<supervisor> selectCodigo(@PathVariable long Codigo){
       supervisor supervisorId = supervisorServicio.selectCod(Codigo);
       return ResponseEntity.ok(supervisorId);
    }
    
    @PutMapping("/supervisor/{Codigo}")
    public ResponseEntity<supervisor> updateCliente(@PathVariable long Codigo, @RequestBody supervisor Supervisor){
            supervisor supervisorCodigo = supervisorServicio.selectCod(Codigo);
            supervisorCodigo.setNombres(Supervisor.getNombres());
            supervisorCodigo.setApellidos(Supervisor.getApellidos());
            supervisorCodigo.setCoreo(Supervisor.getCoreo());
            supervisorCodigo.setTelefono(Supervisor.getTelefono());
            supervisorCodigo.setUsuario(Supervisor.getUsuario());
            supervisorCodigo.setClave(Supervisor.getClave());
            
            
            supervisor actualizador = supervisorServicio.insert(supervisorCodigo);
            return new ResponseEntity<>(actualizador, HttpStatus.CREATED);
    }
	
    @DeleteMapping("/supervisor/{Codigo}")
    public ResponseEntity<HashMap<String,Boolean>> eliminar(@PathVariable long Codigo){
        supervisorServicio.delete(Codigo);

        HashMap<String, Boolean> estadoEliminado = new HashMap<>();
        estadoEliminado.put("Eliminado", true);
        return ResponseEntity.ok(estadoEliminado);
    }
	
    
    
    
}
