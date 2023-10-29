/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.controladores;

import com.skynet.api.modelos.tecnico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.skynet.api.servicios.tecnicoServicioImplementado;
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
public class tecnicoControlador {
    
    @Autowired
    tecnicoServicioImplementado tecnicoServicio;
    
    
    @GetMapping("/tecnico")
    public List<tecnico> selectClientes(){
        
        return tecnicoServicio.selectAll();
    }
    
    @PostMapping("tecnico")
    public ResponseEntity<tecnico> insertCliente(@RequestBody tecnico Tecnico){
        tecnico nueva = tecnicoServicio.insert(Tecnico);
        return new ResponseEntity<>(nueva,HttpStatus.CREATED);
    }
    
     @GetMapping("tecnico/{Codigo}")
    public ResponseEntity<tecnico> selectCodigo(@PathVariable long Codigo){
       tecnico tecnicoId = tecnicoServicio.selectCod(Codigo);
       return ResponseEntity.ok(tecnicoId);
    }
    
    @GetMapping("tecnico/{Codigo}/{Codigo2}")
    public ResponseEntity<tecnico> selectIntro(@PathVariable String Codigo,@PathVariable String Codigo2){
       tecnico usuarioId = tecnicoServicio.selectCod2(Codigo,Codigo2);
       return ResponseEntity.ok(usuarioId);
    }
    
    
    @PutMapping("/tecnico/{Codigo}")
    public ResponseEntity<tecnico> updateCliente(@PathVariable long Codigo, @RequestBody tecnico Tecnico){
            tecnico tecnicoCodigo = tecnicoServicio.selectCod(Codigo);
            tecnicoCodigo.setNombre(Tecnico.getNombre());
            tecnicoCodigo.setTelefono(Tecnico.getTelefono());
            tecnicoCodigo.setCorreo(Tecnico.getCorreo());
            tecnicoCodigo.setCod_supervisor(Tecnico.getCod_supervisor());
            tecnicoCodigo.setUsuario(Tecnico.getUsuario());
            tecnicoCodigo.setClave(Tecnico.getClave());
            
            tecnico actualizador = tecnicoServicio.insert(tecnicoCodigo);
            return new ResponseEntity<>(actualizador, HttpStatus.CREATED);
    }
	
    @GetMapping("tecnicos/{Nombre}")
    public List<tecnico> selectFiltrado(@PathVariable String Nombre){
        
        return tecnicoServicio.selectFiltrado(Nombre);
    }
    
    @DeleteMapping("/tecnico/{Codigo}")
    public ResponseEntity<HashMap<String,Boolean>> eliminar(@PathVariable long Codigo){
        tecnicoServicio.delete(Codigo);

        HashMap<String, Boolean> estadoEliminado = new HashMap<>();
        estadoEliminado.put("Eliminado", true);
        return ResponseEntity.ok(estadoEliminado);
    }
	
    
    
    
}
