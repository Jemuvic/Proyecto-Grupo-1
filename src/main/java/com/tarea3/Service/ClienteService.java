/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tarea3.Service;

import com.tarea3.domain.Cliente;
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
    
}
