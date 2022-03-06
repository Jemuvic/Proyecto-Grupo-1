/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.tarea3.Controller;

import com.tarea3.Service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author ajujargu
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "index";
    }

    @RequestMapping("/listar")
    public String listr(Model model) {
        var clientesDB = clienteService.getCliente();
        model.addAttribute("clientesDB", clientesDB);
        return "listar";
    }

}
