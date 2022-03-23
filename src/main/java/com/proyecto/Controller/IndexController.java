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
    private ContactoService contactoService;

    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "index";
    }
    
    @RequestMapping("/perfil")
    public String perfil (Model model){
        return "perfil";
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
    
     /* Para el html de vista de la noticia*/
      @RequestMapping("/noticias")
    public String noticias(Model model) {
        model.addAttribute("attribute", "value");
        return "noticias";
    }
    


}
