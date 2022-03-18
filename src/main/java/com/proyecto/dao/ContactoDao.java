
package com.proyecto.dao;
import com.proyecto.domain.Contacto;
import org.springframework.data.repository.CrudRepository;

public interface ContactoDao extends CrudRepository<Contacto, Long> {
    
}
