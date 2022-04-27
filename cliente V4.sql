
DROP SCHEMA dailypixels;
DROP USER ADMIN_DB;

CREATE SCHEMA `dailypixels`;
USE dailypixels;

CREATE TABLE cliente (
`idcliente` INT NOT NULL AUTO_INCREMENT , 
`nombre` VARCHAR(30) NOT NULL,
`apellidos` VARCHAR(50) NOT NULL,
`correo` VARCHAR(50) NOT NULL,
`password` VARCHAR(50) NOT NULL, 
`estado` BOOlEAN NOT NULL,
`comentario` VARCHAR(500),
`tipo` VARCHAR(50),
 PRIMARY KEY (`idcliente`)
 );

/*Insertar 3 registros*/
INSERT INTO `dailypixels`.`cliente` (`nombre`, `apellidos`, `correo`,`password`,`estado`,`tipo`)
	VALUES ('Jonathan', 'Brenes Blanco', 'jbrenes@gmail.com', 'jbrenes', FALSE,'ADMIN');

INSERT INTO `dailypixels`.`cliente` (`nombre`, `apellidos`, `correo`,`password`,`estado`,`tipo`)
	VALUES ('Ana', 'Contreras Mora', 'acontreras@gmail.com', 'acontreras', FALSE,'USER');

INSERT INTO `dailypixels`.`cliente` (`nombre`, `apellidos`, `correo`,`password`,`estado`,`tipo`)
	VALUES ('Luis', 'Mena Loria', 'lmena@gmail.com', 'lmena', FALSE,'USER');

INSERT INTO `dailypixels`.`cliente` (`nombre`, `apellidos`, `correo`,`password`,`estado`,`tipo`)
	VALUES ('Fabian', 'Lopez Perez', 'flopez@gmail.com', 'flopez', FALSE,'USER');
    
CREATE USER 'ADMIN_DB' @'%' IDENTIFIED BY 'ADMIN_DB_CLAVE.';

GRANT ALL PRIVILEGES ON dailypixels.* to 'ADMIN_DB';
flush privileges;
