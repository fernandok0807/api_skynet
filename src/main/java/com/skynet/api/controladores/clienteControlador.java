/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.controladores;

import com.skynet.api.modelos.cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.skynet.api.servicios.clienteServicioImplementado;
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
public class clienteControlador {
    
    @Autowired
    clienteServicioImplementado clienteServicio;
    
    @GetMapping("/test")
    public String getCliente(){
        
        return "Hola";
    }
    
    
    @GetMapping("/cliente")
    public List<cliente> selectClientes(){
        
        return clienteServicio.selectAll();
    }
    
    @GetMapping("clientes/{Nombre}")
    public List<cliente> selectFiltrado(@PathVariable String Nombre){
        
        return clienteServicio.selectFiltrado(Nombre);
    }
    
    @PostMapping("cliente")
    public ResponseEntity<cliente> insertCliente(@RequestBody cliente Cliente){
        cliente nueva = clienteServicio.insert(Cliente);
        return new ResponseEntity<>(nueva,HttpStatus.CREATED);
    }
    
     @GetMapping("cliente/{Codigo}")
    public ResponseEntity<cliente> selectCodigo(@PathVariable long Codigo){
       cliente clienteId = clienteServicio.selectCod(Codigo);
       return ResponseEntity.ok(clienteId);
    }
    
    @PutMapping("/cliente/{Codigo}")
    public ResponseEntity<cliente> updateCliente(@PathVariable long Codigo, @RequestBody cliente Cliente){
            cliente clienteCodigo = clienteServicio.selectCod(Codigo);
            clienteCodigo.setNombre(Cliente.getNombre());
            clienteCodigo.setTelefono(Cliente.getTelefono());
            clienteCodigo.setCorreo(Cliente.getCorreo());
            clienteCodigo.setDireccion(Cliente.getDireccion());
            clienteCodigo.setCoordenadas(Cliente.getCoordenadas());
            
            cliente actualizador = clienteServicio.insert(clienteCodigo);
            return new ResponseEntity<>(actualizador, HttpStatus.CREATED);
    }
	
    @DeleteMapping("/cliente/{Codigo}")
    public ResponseEntity<HashMap<String,Boolean>> eliminar(@PathVariable long Codigo){
        clienteServicio.delete(Codigo);

        HashMap<String, Boolean> estadoEliminado = new HashMap<>();
        estadoEliminado.put("Eliminado", true);
        return ResponseEntity.ok(estadoEliminado);
    }
	
    
    
    
}
