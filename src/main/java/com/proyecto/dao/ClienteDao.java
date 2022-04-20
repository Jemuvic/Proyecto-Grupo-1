/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.domain.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ajujargu
 */
public interface ClienteDao extends JpaRepository<Cliente, Long> {

    public Cliente findByCorreoAndPassword(String correo, String password); /* metodo para validar por correo y clave*/
    public Cliente findByEstado(boolean estado); /* metodo para validar por estado y activo*/
    public List<Cliente> findByComentarioNotNull();/* metodo para validar por comentarios*/
}
