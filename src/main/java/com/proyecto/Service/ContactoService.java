/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.Service;

import com.proyecto.domain.Contacto;
import java.util.List;

/**
 *
 * @author ajujargu
 */
public interface ContactoService {
    public List<Contacto> getContacto();
    public void save(Contacto contacto);;
    public void delete(Contacto contacto);
    public Contacto getContacto(Contacto contacto);
}
