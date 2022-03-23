CREATE TABLE `dailypixels`.`contactos` (`idContacto` INT NOT NULL AUTO_INCREMENT, `nombre` VARCHAR(30) NOT NULL, `apellidos` VARCHAR(50) NOT NULL,
`correo` VARCHAR(50) NULL, `telefono` VARCHAR(15) NULL,`descripcion` VARCHAR(500) NULL, PRIMARY KEY (`idContacto`))
ENGINE = innoDB;
INSERT INTO `dailypixels`.`contactos` (`nombre`, `apellidos`, `correo`, `telefono`, `descripcion`)
VALUES ('Jonathan', 'Brenes Blanco', 'jbrenes@gmail.com', '8820-2655', 'Soporte a la pagina');

INSERT INTO `dailypixels`.`contactos` (`nombre`, `apellidos`, `correo`, `telefono`, `descripcion`)
VALUES ('Ana', 'Contreras Mora', 'acontreras@gmail.com', '5456-8789', 'Compra de equipos');

INSERT INTO `dailypixels`.`contactos` (`nombre`, `apellidos`, `correo`, `telefono`, `descripcion`)
VALUES ('Luis', 'Mena Loria', 'lmena@gmail.com', '7898-893', 'Reporte de usuarios');

INSERT INTO `dailypixels`.`contactos` (`nombre`, `apellidos`, `correo`, `telefono`, `descripcion`)
VALUES ('Fabian', 'Lopez Perez', 'flopez@gmail.com', '7898-893','Ayuda con comentarios');
