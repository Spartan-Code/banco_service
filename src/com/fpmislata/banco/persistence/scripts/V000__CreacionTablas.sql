CREATE TABLE `entidadbancaria` (
	`idEntidadBancaria` INT(11) NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NULL DEFAULT NULL,
	`codigoEntidad` VARCHAR(50) NULL DEFAULT NULL,
	`fechaCreacion` DATE NULL DEFAULT NULL,
	`direccion` VARCHAR(100) NULL DEFAULT NULL,
	`CIF` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`idEntidadBancaria`),
	UNIQUE INDEX `codigoEntidad` (`codigoEntidad`)
)
ENGINE=InnoDB
;

CREATE TABLE `user` (
	`idUsuario` INT(10) NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NULL DEFAULT NULL,
	`password` VARCHAR(250) NULL DEFAULT NULL,
	`email` VARCHAR(100) NULL DEFAULT NULL,
	`rol` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`idUsuario`)
)
ENGINE=InnoDB
;
