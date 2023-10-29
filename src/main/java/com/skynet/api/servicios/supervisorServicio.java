/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.servicios;

import com.skynet.api.modelos.supervisor;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Enmanuel
 */
public interface  supervisorServicio {
    
    public List<supervisor> selectAll();
    
    public supervisor insert(supervisor Supervisor);
    
    public supervisor selectCod(long Codigo);
    
    public List<supervisor> selectFiltrado(String Codigo);
    
    
    public void delete(long id);
    
    public supervisor selectCod2(String Codigo,String Codigo2);
}
