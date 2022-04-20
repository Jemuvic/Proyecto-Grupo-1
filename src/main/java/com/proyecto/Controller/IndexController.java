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
import org.springframework.transaction.annotation.Transactional;
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
    public String index(Model model) {
        var clientesActivo = clienteService.findByEstado(true);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model.addAttribute("clientesActivo", clientesActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model, Model model2) {
        var clientesActivo = clienteService.findByEstado(true);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model.addAttribute("clientesActivo", clientesActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        return "perfil";
    }

    @RequestMapping("/nuevoContacto")
    public String nuevoContacto(Contacto contacto, Model model) {
        var clientesActivo = clienteService.findByEstado(true);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model.addAttribute("clientesActivo", clientesActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        return "contactenos";
    }
    @Transactional
    @PostMapping("/guardarContacto")
    public String guardarContacto(Contacto contacto) {
        contactoService.save(contacto);
        return "redirect:/";
    }

    /* Para el html de vista de la noticia*/
    @RequestMapping("/noticias")
    public String noticias(Model model) {
        var clientesActivo = clienteService.findByEstado(true);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model.addAttribute("clientesActivo", clientesActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        return "noticias";
    }

    /* Para el html de lista de foros*/
    @RequestMapping("/inicioForos")
    public String inicioForos(Model model) {
        var clientesActivo = clienteService.findByEstado(true);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model.addAttribute("clientesActivo", clientesActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        return "inicioForos";
    }

    /* Para el html de vista del foro*/
    @RequestMapping("/inicioForos/foros")
    public String foros(Model model, Model model2) {
        var cliente = clienteService.findByComentarioNotNull();
        model.addAttribute("cliente", cliente);
        var clientesActivo = clienteService.findByEstado(true);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model2.addAttribute("clientesActivo", clientesActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        return "foros";
    }
    @Transactional
    @PostMapping("/guardarcomentario")
    public String guardarcomentario(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/inicioForos/foros";
    }

    @GetMapping("/comentarios/{idcliente}")
    public String comentarios(Cliente cliente, Model model, Model model2) {
        var clientedb = clienteService.findByEstado(true);
        cliente.setIdcliente(Long.MIN_VALUE);
        model.addAttribute("cliente", clientedb);
        var clientesActivo = clienteService.findByEstado(true);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model2.addAttribute("clientesActivo", clientesActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        return "comentarios";
    }

    @GetMapping("/comentarios")
    public String nuevoComentario(Cliente cliente, Model model) {
        var clientesActivo = clienteService.findByEstado(true);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        model.addAttribute("clientesActivo", clientesActivo);//SE LE AGREGO UN NUEVO MODELO PARA LO DEL MOSTAR USUARIO
        return "comentarios";
    }
}
