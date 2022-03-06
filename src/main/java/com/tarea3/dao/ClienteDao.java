/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea3.dao;

import com.tarea3.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ajujargu
 */
public interface ClienteDao extends CrudRepository<Cliente, Long> {

}
