/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skynet.api.repositorios.usuarioRepositorio;
import com.skynet.api.modelos.usuario;
import java.util.List;

     
/**
 *
 * @author Enmanuel
 */

@Service
public class usuarioServicioImplementado implements usuarioServicio {
    
    
    @Autowired
    usuarioRepositorio usuarioRepo;

        @Override
    public List<usuario> selectAll() {
        System.out.println("LLamando al servicio");   
        return usuarioRepo.findAll();
    }

    @Override
    public usuario insert(usuario Usuario) {
        return usuarioRepo.save(Usuario);
    }

    @Override
    public usuario selectCod(long Codigo) {
        return usuarioRepo.findById(Codigo).orElse(null);
        
    }

    @Override
    public usuario selectCod2(String Codigo,String Codigo2) {
        return usuarioRepo.findByUsuarioAndClave(Codigo, Codigo2);
    }
    
    @Override
    public List<usuario>  selectFiltrado(String Codigo) {
            return usuarioRepo.findByNombreContains(Codigo);
    }
    
    
    
    @Override
    public void delete(long id) {
        
        usuarioRepo.deleteById(id);
        
    }
    
    
    
    
}
