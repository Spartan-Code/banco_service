ALTER TABLE `banco`.`cuentabancaria` 
ADD COLUMN `pin` VARCHAR(4) NULL DEFAULT NULL AFTER `idUsuario`;
