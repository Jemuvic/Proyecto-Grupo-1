package com.tarea3.controller;

import com.tarea3.domain.Cliente;
import com.tarea3.service.ClienteService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping("/")
    public String page(Model model) {

        model.addAttribute("attribute", "value");
        log.info("Ahora se usa arquitectura MVC (Modelo Vista Controlador)");

        Cliente cliente = new Cliente("Jonathan", "Brenes Blanco", "jbrenes@gmail.com", "8877-9021", "123456789", "heredia");
        model.addAttribute(cliente);

        Cliente cliente2 = new Cliente("Juan", "Rojas Perez", "jrojas@gmail.com", "8844-2465", "Cedula", "Direccion");
        var clientes = Arrays.asList(cliente, cliente2);
        model.addAttribute("clientes", clientes);

        var clientesDB = clienteService.getClientes();
        model.addAttribute("clientesDB", clientesDB);

        return "index";

    }

    @GetMapping("/listar")
    public String listar(Model model) {
        var clientesDB = clienteService.getClientes();
        model.addAttribute("clientesDB", clientesDB);
        return "listar";
    }

}
