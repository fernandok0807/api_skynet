/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.repositorios;

import com.skynet.api.modelos.supervisor;
import com.skynet.api.modelos.usuario;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Enmanuel
 */
public interface supervisorRepositorio extends JpaRepository<supervisor,Long>{
     List<supervisor> findByNombresContains(String nombre);
     supervisor findByUsuarioAndClave(String usuario, String clave);
}
