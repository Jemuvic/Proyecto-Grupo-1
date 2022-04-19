/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Controller;

import com.proyecto.Service.ContactoService;
import com.proyecto.domain.Contacto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private ContactoService contactoService;

    @RequestMapping("/contactenos")
    public String listar(Model model) {
        var contactosDB = contactoService.getContacto();
        model.addAttribute("contactosDB", contactosDB);
        return "contactenos";
    }

    @GetMapping("/nuevoContacto")
    public String nuevoContacto(Contacto contacto) {
        return "contactenos";

    }

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
