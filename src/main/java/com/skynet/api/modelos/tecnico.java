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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tecnico")
public class tecnico implements Serializable{
    
      private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cod_tecnico;
    private int cod_supervisor;
    String nombre, telefono, correo;
    String usuario, clave;
    
    

    public tecnico() {
    }

    public long getCod_tecnico() {
        return cod_tecnico;
    }

    public void setCod_tecnico(long cod_tecnico) {
        this.cod_tecnico = cod_tecnico;
    }

    public int getCod_supervisor() {
        return cod_supervisor;
    }

    public void setCod_supervisor(int cod_supervisor) {
        this.cod_supervisor = cod_supervisor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
    

}
