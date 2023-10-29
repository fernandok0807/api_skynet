/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.controladores;

import com.skynet.api.modelos.usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.skynet.api.servicios.usuarioServicioImplementado;
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
public class usuarioControlador {
    
    @Autowired
    usuarioServicioImplementado usuarioServicio;
    
    
    
    @GetMapping("usuarios/{Nombre}")
    public List<usuario> selectFiltrado(@PathVariable String Nombre){
        
        return usuarioServicio.selectFiltrado(Nombre);
    }
    
    
    @GetMapping("usuario")
    public List<usuario> selectClientes(){
        
        return usuarioServicio.selectAll();
    }
    
    
    @PostMapping("usuario")
    public ResponseEntity<usuario> insertCliente(@RequestBody usuario Usuario){
        usuario nueva = usuarioServicio.insert(Usuario);
        return new ResponseEntity<>(nueva,HttpStatus.CREATED);
    }
    
    @GetMapping("usuario/{Codigo}")
    public ResponseEntity<usuario> selectCodigo(@PathVariable long Codigo){
       usuario usuarioId = usuarioServicio.selectCod(Codigo);
       return ResponseEntity.ok(usuarioId);
    }
    
    
    
    @GetMapping("usuario/{Codigo}/{Codigo2}")
    public ResponseEntity<usuario> selectIntro(@PathVariable String Codigo,@PathVariable String Codigo2){
       usuario usuarioId = usuarioServicio.selectCod2(Codigo,Codigo2);
       return ResponseEntity.ok(usuarioId);
    }
    
    @PutMapping("/usuario/{Codigo}")
    public ResponseEntity<usuario> updateCliente(@PathVariable long Codigo, @RequestBody usuario Usuario){
            usuario usuarioCodigo = usuarioServicio.selectCod(Codigo);
            usuarioCodigo.setNombre(Usuario.getNombre());
            usuarioCodigo.setUsuario(Usuario.getUsuario());
            usuarioCodigo.setClave(Usuario.getClave());
            usuarioCodigo.setTipo(Usuario.getTipo());
            
            
            usuario actualizador = usuarioServicio.insert(usuarioCodigo);
            return new ResponseEntity<>(actualizador, HttpStatus.CREATED);
    }
	
    
    @DeleteMapping("/usuario/{Codigo}")
    public ResponseEntity<HashMap<String,Boolean>> eliminar(@PathVariable long Codigo){
        usuarioServicio.delete(Codigo);

        HashMap<String, Boolean> estadoEliminado = new HashMap<>();
        estadoEliminado.put("Eliminado", true);
        return ResponseEntity.ok(estadoEliminado);
    }
	
    
    
    
}
