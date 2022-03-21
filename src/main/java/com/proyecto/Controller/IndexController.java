/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.Controller;

import com.proyecto.Service.ClienteService;
import com.proyecto.Service.ContactoService;
import com.proyecto.domain.Cliente;
import com.proyecto.domain.Contacto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ajujargu
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private ContactoService contactoService;

    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "index";
    }

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

    @RequestMapping("/nuevoContacto")
    public String nuevoContacto(Contacto contacto) {
        return "contactenos";
    }

    @PostMapping("/guardarContacto")
    public String guardarContacto(Contacto contacto) {
        contactoService.save(contacto);
        return "redirect:/";
    }
    
    @GetMapping("/iniciarSesion")
    public String iniciarSesion(Contacto contacto) {

        return "iniciarSesion";
    }
    
    @GetMapping("/crearUsuario")
    public String crearUsuario(Contacto contacto) {

        return "crearUsuario";
    }
    
     /* Para el html de vista de la noticia*/
      @RequestMapping("/noticias")
    public String noticias(Model model) {
        model.addAttribute("attribute", "value");
        return "noticias";
    }
    


}
