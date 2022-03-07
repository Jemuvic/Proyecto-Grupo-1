/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tarea3.Service;

import com.tarea3.domain.Contacto;
import java.util.List;

/**
 *
 * @author ajujargu
 */
public interface ContactoService {
    public List<Contacto> getContacto();
    public void save(Contacto contacto);;
    public Contacto getContacto(Contacto contacto);
}
