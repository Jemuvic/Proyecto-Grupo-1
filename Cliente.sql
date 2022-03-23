DROP SCHEMA dailypixels;
DROP USER usuario_prueba;

CREATE SCHEMA dailypixels;

CREATE TABLE dailypixels.cliente (idcliente INT NOT NULL AUTO_INCREMENT, nombre VARCHAR(30) NOT NULL, apellidos VARCHAR(50) NOT NULL,
correo VARCHAR(50) NULL, PRIMARY KEY (idcliente))
ENGINE = innoDB;

/*Insertar 3 registros*/
INSERT INTO dailypixels.cliente (nombre, apellidos, correo)
    VALUES ('Jonathan', 'Brenes Blanco', 'jbrenes@gmail.com');

INSERT INTO dailypixels.cliente (nombre, apellidos, correo)
    VALUES ('Ana', 'Contreras Mora', 'acontreras@gmail.com');

INSERT INTO dailypixels.cliente (nombre, apellidos, correo)
    VALUES ('Luis', 'Mena Loria', 'lmena@gmail.com');

INSERT INTO dailypixels.cliente (nombre, apellidos, correo)
    VALUES ('Fabian', 'Lopez Perez', 'flopez@gmail.com');


CREATE USER 'usuario_prueba' @'%' IDENTIFIED BY 'Usuar1o_Clave.';


GRANT ALL PRIVILEGES ON dailypixels.* to 'usuario_prueba';
flush privileges;