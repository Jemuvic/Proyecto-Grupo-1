/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.Service;

import com.proyecto.domain.Cliente;
import java.util.List;

/**
 *
 * @author ajujargu
 */
public interface ClienteService {
    public List<Cliente> getCliente();
    public void save(Cliente cliente);
    public void delete(Cliente cliente);
    public Cliente getCliente(Cliente cliente);
    public Cliente findByCorreoAndPassword(String correo, String password); /* metodo para validar por correo y clave*/
    public Cliente findByEstado(boolean estado); /* metodo para validar por estado activo*/
    public List<Cliente> findByComentarioNotNull();/* metodo para validar por comentarios*/
}
