-- MySQL Script generated by MySQL Workbench
-- Sun Apr 12 21:02:14 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`tabla`
-- -----------------------------------------------------
DROP TABLE tabla;
CREATE TABLE IF NOT EXISTS `mydb`.`tabla` (
  `idtabla` INT NOT NULL AUTO_INCREMENT,
  `datoenviado` VARCHAR(45) NULL,
  `horarecibido` VARCHAR(45) NULL,
  `ip` VARCHAR(45) NULL,
  `tipodato` VARCHAR(45) NULL,
  PRIMARY KEY (`idtabla`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
