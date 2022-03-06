
package com.tarea3.service;

import com.tarea3.dao.ClienteDao;
import com.tarea3.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true) //Maneja transacciones de solo lectura
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional //manejar transacciones de escritura y lectura
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

}