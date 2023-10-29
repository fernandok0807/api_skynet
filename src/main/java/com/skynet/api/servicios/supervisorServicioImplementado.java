/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skynet.api.repositorios.supervisorRepositorio;
import com.skynet.api.modelos.supervisor;
import java.util.List;

     
/**
 *
 * @author Enmanuel
 */

@Service
public class supervisorServicioImplementado implements supervisorServicio {
    
    
    @Autowired
    supervisorRepositorio supervisorRepo;

    @Override
    public List<supervisor> selectAll() {
        System.out.println("LLamando al servicio");   
        return supervisorRepo.findAll();
    }

    @Override
    public supervisor insert(supervisor Supervisor) {
        return supervisorRepo.save(Supervisor);
    }

    @Override
    public supervisor selectCod(long Codigo) {
        return supervisorRepo.findById(Codigo).orElse(null);
    }
    
    @Override
    public supervisor selectCod2(String Codigo,String Codigo2) {
        return supervisorRepo.findByUsuarioAndClave(Codigo, Codigo2);
    }

    @Override
    public void delete(long id) {
      supervisorRepo.deleteById(id);
    }
    
    
    @Override
    public List<supervisor>  selectFiltrado(String Codigo) {
        System.out.println("Filtrado");
            return supervisorRepo.findByNombresContains(Codigo);
    }
    
    
}
