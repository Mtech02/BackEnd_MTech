-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_mtech
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_mtech
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_mtech` DEFAULT CHARACTER SET utf8 ;
USE `db_mtech` ;

-- -----------------------------------------------------
-- Table `db_mtech`.`tb_temas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_mtech`.`tb_temas` (
  `id` BIGINT NOT NULL,
  `cursos` VARCHAR(255) NULL,
  `materiais` VARCHAR(255) NULL,
  `vagas` VARCHAR(255) NULL,
  `canal_apoio` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_mtech`.`tb_postagens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_mtech`.`tb_postagens` (
  `id` BIGINT NOT NULL,
  `titulo` VARCHAR(255) NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  `foto` VARCHAR(255) NULL,
  `tb_temas_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_postagens_tb_temas_idx` (`tb_temas_id` ASC) VISIBLE,
  CONSTRAINT `fk_tb_postagens_tb_temas`
    FOREIGN KEY (`tb_temas_id`)
    REFERENCES `db_mtech`.`tb_temas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_mtech`.`tb_pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_mtech`.`tb_pessoa` (
  `id` CHAR(14) NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `senha` VARCHAR(255) NOT NULL,
  `segmento` VARCHAR(255) NULL,
  `ie` VARCHAR(255) NULL,
  `tb_postagens_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_pessoa_tb_postagens1_idx` (`tb_postagens_id` ASC) VISIBLE,
  CONSTRAINT `fk_tb_pessoa_tb_postagens1`
    FOREIGN KEY (`tb_postagens_id`)
    REFERENCES `db_mtech`.`tb_postagens` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
