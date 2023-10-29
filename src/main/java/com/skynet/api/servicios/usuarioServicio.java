/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.servicios;

import com.skynet.api.modelos.usuario;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Enmanuel
 */
public interface  usuarioServicio {
    
    public List<usuario> selectAll();
    
    public usuario insert(usuario Usuario);
    
    public usuario selectCod(long Codigo);
    
    public usuario selectCod2(String Codigo,String Codigo2);
    
    public List<usuario> selectFiltrado(String Codigo);
    
    public void delete(long id);
    
}
