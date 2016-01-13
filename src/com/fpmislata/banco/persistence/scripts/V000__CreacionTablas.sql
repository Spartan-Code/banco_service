CREATE TABLE `usuario` (
	`idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
	`nickName` VARCHAR(50) NULL DEFAULT NULL,
	`password` VARCHAR(250) NULL DEFAULT NULL,
	`nombre` VARCHAR(100) NULL DEFAULT NULL,
	`nif` VARCHAR(9) NULL DEFAULT NULL,
	`email` VARCHAR(100) NULL DEFAULT NULL,
	`rol` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`idUsuario`),
	UNIQUE INDEX `nickName` (`nickName`),
	UNIQUE INDEX `email` (`email`),
	UNIQUE INDEX `nif` (`nif`)
)
ENGINE=InnoDB
;

CREATE TABLE `entidadbancaria` (
	`idEntidadBancaria` INT(11) NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NULL DEFAULT NULL,
	`codigoEntidad` VARCHAR(4) NULL DEFAULT NULL,
	`fechaCreacion` DATE NULL DEFAULT NULL,
	`direccion` VARCHAR(100) NULL DEFAULT NULL,
	`cif` VARCHAR(9) NULL DEFAULT NULL,
	PRIMARY KEY (`idEntidadBancaria`),
	UNIQUE INDEX `codigoEntidad` (`codigoEntidad`),
	UNIQUE INDEX `cif` (`cif`)
)
ENGINE=InnoDB
;

CREATE TABLE `sucursalbancaria` (
	`idSucursalBancaria` INT(11) NOT NULL AUTO_INCREMENT,
	`codigoSucursal` VARCHAR(4) NULL DEFAULT NULL,
	`nombre` VARCHAR(50) NULL DEFAULT NULL,
	`fechaCreacion` DATE NULL DEFAULT NULL,
	`direccion` VARCHAR(100) NULL DEFAULT NULL,
	`poblacion` VARCHAR(50) NULL DEFAULT NULL,
	`codigoPostal` VARCHAR(5) NULL DEFAULT NULL,
	`telefono` VARCHAR(20) NULL DEFAULT NULL,
	`email` VARCHAR(100) NULL DEFAULT NULL,
	`idEntidadBancaria` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`idSucursalBancaria`),
	UNIQUE INDEX `codigoSucursal` (`codigoSucursal`),
	INDEX `FK__entidadbancaria` (`idEntidadBancaria`),
	CONSTRAINT `FK__entidadbancaria` FOREIGN KEY (`idEntidadBancaria`) REFERENCES `entidadbancaria` (`idEntidadBancaria`)
)
ENGINE=InnoDB
;

CREATE TABLE `cuentabancaria` (
	`idCuentaBancaria` INT(11) NOT NULL AUTO_INCREMENT,
	`numeroCuenta` VARCHAR(10) NULL DEFAULT NULL,
	`fechaCreacion` DATE NULL DEFAULT NULL,
	`saldo` DECIMAL(20,2) NULL DEFAULT NULL,
	`idSucursalBancaria` INT(11) NULL DEFAULT NULL,
	`idUsuario` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`idCuentaBancaria`),
	UNIQUE INDEX `numeroCuenta` (`numeroCuenta`),
	INDEX `FK__sucursalbancaria` (`idSucursalBancaria`),
	INDEX `FK__usuario` (`idUsuario`),
	CONSTRAINT `FK__sucursalbancaria` FOREIGN KEY (`idSucursalBancaria`) REFERENCES `sucursalbancaria` (`idSucursalBancaria`),
	CONSTRAINT `FK__usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
)
ENGINE=InnoDB
;

CREATE TABLE `movimientobancario` (
	`idMovimientoBancario` INT(11) NOT NULL AUTO_INCREMENT,
	`fecha` DATE NULL DEFAULT NULL,
	`concepto` VARCHAR(100) NULL DEFAULT NULL,
	`tipo` VARCHAR(20) NULL DEFAULT NULL,
	`importe` DECIMAL(20,2) NULL DEFAULT NULL,
	`saldo` DECIMAL(20,2) NULL DEFAULT NULL,
	`idCuentaBancaria` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`idMovimientoBancario`),
	INDEX `FK__cuentabancaria` (`idCuentaBancaria`),
	CONSTRAINT `FK__cuentabancaria` FOREIGN KEY (`idCuentaBancaria`) REFERENCES `cuentabancaria` (`idCuentaBancaria`)
)
ENGINE=InnoDB
;

INSERT INTO `banco`.`usuario` (`nickName`, `password`, `nombre`, `email`, `rol`) VALUES ('admin', 'Txl6xuMK5cZPex8Z7HpMpbWc65KOIug1WYjYkMs+gsrlO7NxW6IIYGgyIMNXeBZz', 'admin', 'aaaaaaaaaaaaaaaaaaaaaaa@hotmail.com', 'Trabajador');