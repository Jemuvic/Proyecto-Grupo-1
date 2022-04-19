/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Controller;

import com.proyecto.Service.ClienteReportService;
import com.proyecto.Service.ClienteService;
import com.proyecto.domain.Cliente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /*Validadcion del Usuario y Guardado del estado*/
    @PostMapping("/validarSesion")
    @Transactional
    public String validarSesion(Cliente cliente, Model model) {
        if (clienteService.findByCorreoAndPassword(cliente.getCorreo(), cliente.getPassword()) == null) {
            return "iniciarSesion";
        } else {
            cliente.setApellidos(clienteService.findByCorreoAndPassword(cliente.getCorreo(), cliente.getPassword()).getApellidos());
            cliente.setNombre(clienteService.findByCorreoAndPassword(cliente.getCorreo(), cliente.getPassword()).getNombre());
            cliente.setIdcliente(clienteService.findByCorreoAndPassword(cliente.getCorreo(), cliente.getPassword()).getIdcliente());
            cliente.setCorreo(clienteService.findByCorreoAndPassword(cliente.getCorreo(), cliente.getPassword()).getCorreo());
            cliente.setPassword(clienteService.findByCorreoAndPassword(cliente.getCorreo(), cliente.getPassword()).getPassword());
            cliente.setEstado(true);
            clienteService.save(cliente);
            var clientesDB = clienteService.findByEstado(true);
            model.addAttribute("clientesDB", clientesDB);
            return "menuPrincipal";
        }
    }

    /*Metodo para cerrar sesion y cambiar el estado*/
    @GetMapping("/cerrarSesion")
    @Transactional
    public String cerrarSesion(Model model) {
        var cliente = clienteService.findByEstado(true);
        cliente.setEstado(false);
        clienteService.save(cliente);
        return "redirect:/";
    }

    /* Para el html de crearUsuario*/
    @GetMapping("/crearUsuario")
    public String crearUsuario(Cliente cliente) {
        return "crearUsuario";
    }

    @Autowired
    private ClienteReportService clienteReportService;

    @GetMapping(value = "/cliente/ReporteClientes", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFile() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(clienteReportService.generateReport()));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);
            return targetArray;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
