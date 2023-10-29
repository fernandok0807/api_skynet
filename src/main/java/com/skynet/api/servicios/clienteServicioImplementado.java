/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skynet.api.repositorios.clienteRepositorio;
import com.skynet.api.modelos.cliente;
import java.util.List;

     
/**
 *
 * @author Enmanuel
 */

@Service
public class clienteServicioImplementado implements clienteServicio {
    
    
    @Autowired
    clienteRepositorio clienteRepo;

        @Override
    public List<cliente> selectAll() {
        System.out.println("LLamando al servicio");   
        return clienteRepo.findAll();
    }

    @Override
    public cliente insert(cliente Cliente) {
        return clienteRepo.save(Cliente);
    }

    @Override
    public cliente selectCod(long Codigo) {
        return clienteRepo.findById(Codigo).orElse(null);
    }
    

    @Override
    public void delete(long id) {
      clienteRepo.deleteById(id);
    }
    
    @Override
    public List<cliente>  selectFiltrado(String Codigo) {
        System.out.println("Filtrado");
            return clienteRepo.findByNombreContains(Codigo);
    }
    
    
    
}
