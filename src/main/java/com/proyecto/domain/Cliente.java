/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.util.Date;
/**
 *
 * @author ajujargu
 */
@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcliente;
    private String nombre;
    private String apellidos;
    private String correo;
    private String password;
    private boolean estado;
    private String comentario;
    private String tipo;
    
    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String password, boolean estado, String comentario, String tipo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
        this.estado = estado;
        this.comentario = comentario;
        this.tipo = tipo;
    }
}
//SE ELIMINO LA VARIABLE FECHA