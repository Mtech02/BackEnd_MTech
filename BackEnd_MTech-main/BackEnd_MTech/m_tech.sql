-- MySQL Script generated by MySQL Workbench
-- Fri Mar 11 14:05:23 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_mtech_der
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_mtech
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_mtech
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_mtech` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `db_mtech` ;

-- -----------------------------------------------------
-- Table `db_mtech`.`tb_theme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_mtech`.`tb_theme` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_mtech`.`tb_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_mtech`.`tb_user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `photo` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_mtech`.`tb_post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_mtech`.`tb_post` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `date` DATETIME(6) NULL DEFAULT NULL,
  `text` VARCHAR(1000) NULL DEFAULT NULL,
  `title` VARCHAR(100) NULL DEFAULT NULL,
  `theme_id` BIGINT NULL DEFAULT NULL,
  `user_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKdgc7ypo7yd4tvsthfw3kwd5mk` (`theme_id` ASC) VISIBLE,
  INDEX `FKhx7a7k3pf66vpddqg5pr12anw` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKdgc7ypo7yd4tvsthfw3kwd5mk`
    FOREIGN KEY (`theme_id`)
    REFERENCES `db_mtech`.`tb_theme` (`id`),
  CONSTRAINT `FKhx7a7k3pf66vpddqg5pr12anw`
    FOREIGN KEY (`user_id`)
    REFERENCES `db_mtech`.`tb_user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
