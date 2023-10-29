/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.servicios;

import com.skynet.api.modelos.cliente;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Enmanuel
 */
public interface  clienteServicio {
    
    public List<cliente> selectAll();
    
    public cliente insert(cliente Cliente);
    
    public cliente selectCod(long Codigo);
    
    public void delete(long id);
    
    public List<cliente> selectFiltrado(String Codigo);
    
    
    
}
