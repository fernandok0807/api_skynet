/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.repositorios;

import com.skynet.api.modelos.tecnico;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Enmanuel
 */
public interface tecnicoRepositorio extends JpaRepository<tecnico,Long>{
    
    
    List<tecnico> findByNombreContains(String nombre);
     tecnico findByUsuarioAndClave(String usuario, String clave);
}
