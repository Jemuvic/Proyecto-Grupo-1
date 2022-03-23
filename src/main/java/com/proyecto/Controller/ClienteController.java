/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Controller;

import com.proyecto.Service.ClienteService;
import com.proyecto.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Pc
 */
@Controller
@Slf4j
public class ClienteController {
       
     @Autowired
    private ClienteService clienteService;
      
      @RequestMapping("/listar")
    public String listar(Model model) {
        var clientesDB = clienteService.getCliente();
        model.addAttribute("clientesDB", clientesDB);
        return "listar";
    }
    
     @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente) {
        return "modificarCliente";

    }

    @PostMapping("/guardarcliente")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/listar";
    }

    @GetMapping("/modificarCliente/{idcliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        var respuesta = clienteService.getCliente(cliente);
        model.addAttribute("cliente", respuesta);
        return "modificarCliente";
    }

    @GetMapping("/eliminarCliente/{idcliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/listar";
    }
    
    /* Para el html de iniciarSesion*/
    @GetMapping("/iniciarSesion")
    public String iniciarSesion(Cliente cliente) {

        return "iniciarSesion";
    }
    
    /* Para el html de crearUsuario*/
    @GetMapping("/crearUsuario")
    public String crearUsuario(Cliente cliente) {

        return "crearUsuario";
    }
    
}
