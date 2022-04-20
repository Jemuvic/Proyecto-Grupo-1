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

    @Autowired
    private ClienteService clienteService;
    
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
    
    /* Para el html de lista de foros*/
      @RequestMapping("/inicioForos")
    public String inicioForos(Model model) {
        model.addAttribute("attribute", "value");
        return "inicioForos";
    }
    
    /* Para el html de vista del foro*/
    @RequestMapping("/inicioForos/foros")   
    public String foros(Model model, Model model2) {
        var cliente = clienteService.getCliente();
        model.addAttribute("cliente", cliente);
        var clienteActivo = clienteService.findByEstado(true);
        model2.addAttribute("clienteActivo", clienteActivo);
        return "foros";
    }
    
    @PostMapping("/guardarcomentario")
    public String guardarComentario(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/foro";
    }
    
    @GetMapping("/comentarios/{idcliente}")
    public String comentarios(Cliente cliente, Model model) {
        var respuesta = clienteService.getCliente(cliente);
        model.addAttribute("cliente", respuesta);
        return "comentarios"; 
    }
    
    //@GetMapping("/comentarios")
   // public String comentarios(Cliente cliente) {
       // return "comentarios";
    }



