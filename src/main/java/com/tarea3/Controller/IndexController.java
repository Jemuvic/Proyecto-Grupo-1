/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.tarea3.Controller;

import com.tarea3.Service.ClienteService;
import com.tarea3.Service.ContactoService;
import com.tarea3.domain.Contacto;
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

    @RequestMapping("/nuevoContacto")
    public String nuevoContacto(Contacto contacto) {
        return "contactenos";
    }

    @PostMapping("/guardarContacto")
    public String guardarContacto(Contacto contacto) {
        contactoService.save(contacto);
        return "redirect:/";
    }

}
