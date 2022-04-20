DROP SCHEMA dailypixels;
DROP USER ADMIN_DB;

CREATE SCHEMA `dailypixels`;
USE dailypixels;

CREATE TABLE cliente (
`idcliente` INT NOT NULL AUTO_INCREMENT , 
`nombre` VARCHAR(30) NOT NULL,
`apellidos` VARCHAR(50) NOT NULL,
`correo` VARCHAR(50) NOT NULL UNIQUE,
`password` VARCHAR(50) NOT NULL, 
`estado` BOOlEAN NOT NULL,
 PRIMARY KEY (`idcliente`)
 );

/*Insertar 3 registros*/
INSERT INTO `dailypixels`.`cliente` (`nombre`, `apellidos`, `correo`,`password`,`estado`)
	VALUES ('Jonathan', 'Brenes Blanco', 'jbrenes@gmail.com', 'jbrenes', FALSE);

INSERT INTO `dailypixels`.`cliente` (`nombre`, `apellidos`, `correo`,`password`,`estado`)
	VALUES ('Ana', 'Contreras Mora', 'acontreras@gmail.com', 'acontreras', FALSE);

INSERT INTO `dailypixels`.`cliente` (`nombre`, `apellidos`, `correo`,`password`,`estado`)
	VALUES ('Luis', 'Mena Loria', 'lmena@gmail.com', 'lmena', FALSE);

INSERT INTO `dailypixels`.`cliente` (`nombre`, `apellidos`, `correo`,`password`,`estado`)
	VALUES ('Fabian', 'Lopez Perez', 'flopez@gmail.com', 'flopez', FALSE);
    
CREATE USER 'ADMIN_DB' @'%' IDENTIFIED BY 'ADMIN_DB_CLAVE.';

GRANT ALL PRIVILEGES ON dailypixels.* to 'ADMIN_DB';
flush privileges;

ALTER USER 'ADMIN_DB'@'localhost' IDENTIFIED WITH mysql_native_password BY 
'Usuar1o_Clave.';
flush privileges
