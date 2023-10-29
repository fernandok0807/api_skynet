/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.controladores;

import com.skynet.api.modelos.visita;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.skynet.api.servicios.visitaServicioImplementado;
import java.util.HashMap;
import java.util.HashSet;
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
public class visitaControlador {
    
    @Autowired
    visitaServicioImplementado visitaServicio;
    
    
    @GetMapping("/visita")
    public List<visita> selectClientes(){
        
        return visitaServicio.selectAll();
    }
    
    @PostMapping("visita")
    public ResponseEntity<visita> insertCliente(@RequestBody visita Visita){
        visita nueva = visitaServicio.insert(Visita);
        return new ResponseEntity<>(nueva,HttpStatus.CREATED);
    }
    
     @GetMapping("visita/{Codigo}")
    public ResponseEntity<visita> selectCodigo(@PathVariable long Codigo){
       visita visitaId = visitaServicio.selectCod(Codigo);
       return ResponseEntity.ok(visitaId);
    }
    
    
    
     @GetMapping("visitas/{Codigo}")
    public List<visita> selectCliente(@PathVariable long Codigo){
       
        return visitaServicio.selectTec(Codigo);
       
    }
    
    @PutMapping("/visita/{Codigo}")
    public ResponseEntity<visita> updateCliente(@PathVariable long Codigo, @RequestBody visita Visita){
            visita visitaCodigo = visitaServicio.selectCod(Codigo);
            visitaCodigo.setCodtecnico(Visita.getCodtecnico());
            visitaCodigo.setCod_cliente(Visita.getCod_cliente());
            visitaCodigo.setIngreso(Visita.getIngreso());
            visitaCodigo.setEgreso(Visita.getEgreso());
            visitaCodigo.setCoordenada(Visita.getCoordenada());
            visitaCodigo.setReporte(Visita.getReporte());
        
            
            visita actualizador = visitaServicio.insert(visitaCodigo);
            return new ResponseEntity<>(actualizador, HttpStatus.CREATED);
    }
	
    @DeleteMapping("/visita/{Codigo}")
    public ResponseEntity<HashMap<String,Boolean>> eliminar(@PathVariable long Codigo){
        visitaServicio.delete(Codigo);

        HashMap<String, Boolean> estadoEliminado = new HashMap<>();
        estadoEliminado.put("Eliminado", true);
        return ResponseEntity.ok(estadoEliminado);
    }
	
    
    
    
}
