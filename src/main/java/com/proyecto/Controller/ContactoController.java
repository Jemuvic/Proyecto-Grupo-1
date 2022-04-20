/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Controller;

import com.proyecto.Service.ClienteService;
import com.proyecto.Service.ContactoService;
import com.proyecto.domain.Contacto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author XPC
 */
@Controller
@Slf4j
public class ContactoController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ContactoService contactoService;

    @RequestMapping("/contactenos")
    public String listar(Model model, Model model2) {
        var contactosDB = contactoService.getContacto();
        model.addAttribute("contactosDB", contactosDB);
        var clientesActivo = clienteService.findByEstado(true);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model2.addAttribute("clientesActivo", clientesActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        return "contactenos";
    }

    @GetMapping("/nuevoContacto")
    public String nuevoContacto(Contacto contacto,Model model) {
        var clientesActivo = clienteService.findByEstado(true);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model.addAttribute("clientesActivo", clientesActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        return "contactenos";

    }
    @Transactional
    @PostMapping("/guardarcontacto")
    public String guardarContacto(Contacto contacto) {
        contactoService.save(contacto);
        return "redirect:/listar";
    }

    @GetMapping("/eliminarContacto/{idcontacto}")
    public String eliminarContacto(Contacto contacto) {
        contactoService.delete(contacto);
        return "redirect:/listar";
    }
}
