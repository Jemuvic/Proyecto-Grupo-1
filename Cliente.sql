DROP SCHEMA dailypixels;
DROP USER usuario_prueba;

CREATE SCHEMA `dailypixels`;

CREATE TABLE `dailypixels`.`cliente` (`idcliente` INT NOT NULL AUTO_INCREMENT, `nombre` VARCHAR(30) NOT NULL, `apellidos` VARCHAR(50) NOT NULL,
`correo` VARCHAR(50) NULL,`password` VARCHAR(50) NOT NULL, `estado` BOOL NULL, PRIMARY KEY (`idcliente`))
ENGINE = innoDB;

/*Insertar 3 registros*/
INSERT INTO `dailypixels`.`cliente` (`nombre`, `apellidos`, `correo`,`password`,`estado`)
	VALUES ('Jonathan', 'Brenes Blanco', 'jbrenes@gmail.com', 'jbrenes', '1');
    
INSERT INTO `dailypixels`.`cliente` (`nombre`, `apellidos`, `correo`,`password`,`estado`)
	VALUES ('Ana', 'Contreras Mora', 'acontreras@gmail.com', 'acontreras', '1');
    
INSERT INTO `dailypixels`.`cliente` (`nombre`, `apellidos`, `correo`,`password`,`estado`)
	VALUES ('Luis', 'Mena Loria', 'lmena@gmail.com', 'lmena', '1');
    
INSERT INTO `dailypixels`.`cliente` (`nombre`, `apellidos`, `correo`,`password`,`estado`)
	VALUES ('Fabian', 'Lopez Perez', 'flopez@gmail.com', 'flopez', '1');


CREATE USER 'usuario_prueba' @'%' IDENTIFIED BY 'Usuar1o_Clave.';


GRANT ALL PRIVILEGES ON dailypixels.* to 'usuario_prueba';
flush privileges;
