/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.servicios;

import com.skynet.api.modelos.visita;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Enmanuel
 */
public interface  visitaServicio {
    
    public List<visita> selectAll();
    
    public visita insert(visita Visita);
    
    public visita selectCod(long Codigo);
    
    public List<visita> selectTec(long Codigo);
    
    
    public void delete(long id);
    
}
