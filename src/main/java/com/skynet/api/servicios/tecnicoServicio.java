/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.servicios;

import com.skynet.api.modelos.tecnico;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Enmanuel
 */
public interface  tecnicoServicio {
    
    public List<tecnico> selectAll();
    
    public tecnico insert(tecnico Tecnico);
    
    public tecnico selectCod(long Codigo);
    
    public void delete(long id);
    public List<tecnico> selectFiltrado(String Codigo);
    
     public tecnico selectCod2(String Codigo,String Codigo2);
}