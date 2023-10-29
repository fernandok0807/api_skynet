/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skynet.api.modelos;

/**
 *
 * @author Enmanuel
 */
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "visita")
public class visita implements Serializable{
    
      private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cod_visita;
    @Column(name = "cod_tecnico")
    private long codtecnico;
    private long cod_cliente;
    
    String ingreso,egreso;
    String coordenada;

    String reporte;
    
    
    public visita() {
    }

    public long getCodtecnico() {
        return codtecnico;
    }

    public void setCodtecnico(long codtecnico) {
        this.codtecnico = codtecnico;
    }

    public long getCod_visita() {
        return cod_visita;
    }

    
    public void setCod_visita(long cod_visita) {
        this.cod_visita = cod_visita;
    }

    public long getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(long cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getEgreso() {
        return egreso;
    }

    
    public void setEgreso(String egreso) {
        this.egreso = egreso;
    }

   

    public String getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }
    
    
    
}
