
package com.proyecto.domain;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "contactos")
public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContacto;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String descripcion;

    public Contacto() {
    }

    public Contacto(Long idContacto, String nombre, String apellidos, String correo, String telefono, String descripcion) {
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    
}
