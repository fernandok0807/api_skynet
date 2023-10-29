/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skynet.api.repositorios.visitaRepositorio;
import com.skynet.api.modelos.visita;
import java.util.List;

     
/**
 *
 * @author Enmanuel
 */

@Service
public class visitaServicioImplementado implements visitaServicio {
    
    
    @Autowired
    visitaRepositorio visitaRepo;

    @Override
    public List<visita> selectAll() {
        System.out.println("LLamando al servicio");   
        return visitaRepo.findAll();
    }

    @Override
    public visita insert(visita Visita) {
        return visitaRepo.save(Visita);
    }

    @Override
    public visita selectCod(long Codigo) {
       return visitaRepo.findById(Codigo).orElse(null);
    }

    @Override
    public List<visita>  selectTec(long Codigo) {
       return visitaRepo.findByCodtecnico(Codigo);
    }
    
    @Override
    public void delete(long id) {
      
        visitaRepo.deleteById(id);
    }
    
    
    
    
}
