/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.domain;

import com.proyecto.Service.ClienteService;
import com.proyecto.dao.ClienteDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ajujargu
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getCliente() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdcliente()).orElse(null);
    }
 /* metodo para valisar por correo y clave*/
    @Override
    public Cliente findByCorreoAndPassword(String correo, String password) {
        return clienteDao.findByCorreoAndPassword(correo, password);
    }
 /* metodo para valisar por estado de activo*/
    @Override
    @Transactional(readOnly = true)
    public Cliente findByEstado(boolean estado) {
        return clienteDao.findByEstado(estado);
    }

}
