/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skynet.api.repositorios.tecnicoRepositorio;
import com.skynet.api.modelos.tecnico;
import java.util.List;

     
/**
 *
 * @author Enmanuel
 */

@Service
public class tecnicoServicioImplementado implements tecnicoServicio {
    
    
    @Autowired
    tecnicoRepositorio tecnicoRepo;

    @Override
    public List<tecnico> selectAll() {
        System.out.println("LLamando al servicio");   
        return tecnicoRepo.findAll();
    }

    @Override
    public tecnico insert(tecnico Tecnico) {
        return tecnicoRepo.save(Tecnico);
    }

    @Override
    public tecnico selectCod(long Codigo) {
        return tecnicoRepo.findById(Codigo).orElse(null);
    }
    
    @Override
    public tecnico selectCod2(String Codigo,String Codigo2) {
        return tecnicoRepo.findByUsuarioAndClave(Codigo, Codigo2);
    }

    @Override
    public void delete(long id) {
        tecnicoRepo.deleteById(id);
    }
    
    
     @Override
    public List<tecnico>  selectFiltrado(String Codigo) {
            return tecnicoRepo.findByNombreContains(Codigo);
    }
    
}
