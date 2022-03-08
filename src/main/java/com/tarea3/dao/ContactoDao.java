
package com.tarea3.dao;
import com.tarea3.domain.Contacto;
import org.springframework.data.repository.CrudRepository;

public interface ContactoDao extends CrudRepository<Contacto, Long> {
    
}
