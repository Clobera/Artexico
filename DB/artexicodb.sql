-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema artexicodb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `artexicodb` ;

-- -----------------------------------------------------
-- Schema artexicodb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `artexicodb` DEFAULT CHARACTER SET utf8 ;
USE `artexicodb` ;

-- -----------------------------------------------------
-- Table `borough`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `borough` ;

CREATE TABLE IF NOT EXISTS `borough` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(200) NOT NULL,
  `username` VARCHAR(100) NOT NULL,
  `password` TEXT NOT NULL,
  `enabled` TINYINT NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `image_url` TEXT NULL,
  `bio` TEXT NULL,
  `account_type` VARCHAR(45) NOT NULL DEFAULT 'guest',
  `borough_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `fk_user_neighborhood1_idx` (`borough_id` ASC),
  CONSTRAINT `fk_user_neighborhood1`
    FOREIGN KEY (`borough_id`)
    REFERENCES `borough` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artwork_medium`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `artwork_medium` ;

CREATE TABLE IF NOT EXISTS `artwork_medium` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theme`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `theme` ;

CREATE TABLE IF NOT EXISTS `theme` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artwork`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `artwork` ;

CREATE TABLE IF NOT EXISTS `artwork` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `description` TEXT NOT NULL,
  `image` TEXT NOT NULL,
  `for_sale` TINYINT NOT NULL,
  `enabled` TINYINT NOT NULL,
  `dimension_height` INT NOT NULL,
  `dimension_width` INT NOT NULL,
  `dimension_length` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  `artist_id` INT NOT NULL,
  `medium_id` INT NOT NULL,
  `theme_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_art_piece_user_idx` (`artist_id` ASC),
  INDEX `fk_art_piece_medium1_idx` (`medium_id` ASC),
  INDEX `fk_artwork_theme1_idx` (`theme_id` ASC),
  CONSTRAINT `fk_art_piece_user`
    FOREIGN KEY (`artist_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_art_piece_medium1`
    FOREIGN KEY (`medium_id`)
    REFERENCES `artwork_medium` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_artwork_theme1`
    FOREIGN KEY (`theme_id`)
    REFERENCES `theme` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `movement` ;

CREATE TABLE IF NOT EXISTS `movement` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `material` ;

CREATE TABLE IF NOT EXISTS `material` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artwork_has_material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `artwork_has_material` ;

CREATE TABLE IF NOT EXISTS `artwork_has_material` (
  `artwork_id` INT NOT NULL,
  `material_id` INT NOT NULL,
  PRIMARY KEY (`artwork_id`, `material_id`),
  INDEX `fk_art_piece_has_material_material1_idx` (`material_id` ASC),
  INDEX `fk_art_piece_has_material_art_piece1_idx` (`artwork_id` ASC),
  CONSTRAINT `fk_art_piece_has_material_art_piece1`
    FOREIGN KEY (`artwork_id`)
    REFERENCES `artwork` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_art_piece_has_material_material1`
    FOREIGN KEY (`material_id`)
    REFERENCES `material` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artwork_has_movement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `artwork_has_movement` ;

CREATE TABLE IF NOT EXISTS `artwork_has_movement` (
  `artwork_id` INT NOT NULL,
  `movement_id` INT NOT NULL,
  PRIMARY KEY (`artwork_id`, `movement_id`),
  INDEX `fk_artwork_has_movement_movement1_idx` (`movement_id` ASC),
  INDEX `fk_artwork_has_movement_artwork1_idx` (`artwork_id` ASC),
  CONSTRAINT `fk_artwork_has_movement_artwork1`
    FOREIGN KEY (`artwork_id`)
    REFERENCES `artwork` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_artwork_has_movement_movement1`
    FOREIGN KEY (`movement_id`)
    REFERENCES `movement` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_bookmarked_artwork`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_bookmarked_artwork` ;

CREATE TABLE IF NOT EXISTS `user_has_bookmarked_artwork` (
  `user_id` INT NOT NULL,
  `artwork_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `artwork_id`),
  INDEX `fk_user_has_artwork_artwork1_idx` (`artwork_id` ASC),
  INDEX `fk_user_has_artwork_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_artwork_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_artwork_artwork1`
    FOREIGN KEY (`artwork_id`)
    REFERENCES `artwork` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS admin@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'admin'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `borough`
-- -----------------------------------------------------
START TRANSACTION;
USE `artexicodb`;
INSERT INTO `borough` (`id`, `name`) VALUES (1, 'Álvaro Obregón');
INSERT INTO `borough` (`id`, `name`) VALUES (2, 'Azcapotzalco');
INSERT INTO `borough` (`id`, `name`) VALUES (3, 'Benito Juárez');
INSERT INTO `borough` (`id`, `name`) VALUES (4, 'Coyoacán');
INSERT INTO `borough` (`id`, `name`) VALUES (5, 'Cuajimalpa de Morelos');
INSERT INTO `borough` (`id`, `name`) VALUES (6, 'Cuauhtémoc');
INSERT INTO `borough` (`id`, `name`) VALUES (7, 'Gustavo A. Madero');
INSERT INTO `borough` (`id`, `name`) VALUES (8, 'Iztacalco');
INSERT INTO `borough` (`id`, `name`) VALUES (9, 'Iztapalapa');
INSERT INTO `borough` (`id`, `name`) VALUES (10, 'La Magdalena Contreras');
INSERT INTO `borough` (`id`, `name`) VALUES (11, 'Miguel Hidalgo');
INSERT INTO `borough` (`id`, `name`) VALUES (12, 'Milpa Alta');
INSERT INTO `borough` (`id`, `name`) VALUES (13, 'Tláhuac');
INSERT INTO `borough` (`id`, `name`) VALUES (14, 'Tlalpan');
INSERT INTO `borough` (`id`, `name`) VALUES (15, 'Venustiano Carranza');
INSERT INTO `borough` (`id`, `name`) VALUES (16, 'Xochimilco');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `artexicodb`;
INSERT INTO `user` (`id`, `email`, `username`, `password`, `enabled`, `role`, `first_name`, `last_name`, `image_url`, `bio`, `account_type`, `borough_id`) VALUES (1, 'carlosclobera@gmail.com', 'clobera', '$2a$10$4SMKDcs9jT18dbFxqtIqDeLEynC7MUrCEUbv1a/bhO.x9an9WGPvm', 1, 'admin', 'Carlos', 'Lobera', NULL, NULL, 'artist', 1);
INSERT INTO `user` (`id`, `email`, `username`, `password`, `enabled`, `role`, `first_name`, `last_name`, `image_url`, `bio`, `account_type`, `borough_id`) VALUES (2, 'carloslobera@gmail.com', 'bdobbs', '$2a$10$EGfvuDgIKqhmzlDf34s/aOxU0fSWf/2uZnxQqcIS3n9j7cIwIqnFa', 1, 'admin', 'test', 'test', NULL, NULL, 'artist', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `artwork_medium`
-- -----------------------------------------------------
START TRANSACTION;
USE `artexicodb`;
INSERT INTO `artwork_medium` (`id`, `name`) VALUES (1, 'Medium Test');

COMMIT;


-- -----------------------------------------------------
-- Data for table `theme`
-- -----------------------------------------------------
START TRANSACTION;
USE `artexicodb`;
INSERT INTO `theme` (`id`, `name`) VALUES (1, 'Theme test');

COMMIT;


-- -----------------------------------------------------
-- Data for table `artwork`
-- -----------------------------------------------------
START TRANSACTION;
USE `artexicodb`;
INSERT INTO `artwork` (`id`, `title`, `price`, `description`, `image`, `for_sale`, `enabled`, `dimension_height`, `dimension_width`, `dimension_length`, `created_at`, `artist_id`, `medium_id`, `theme_id`) VALUES (1, 'test', 10.99, 'test test test', 'image', 0, 1, 10, 10, 10, '2023-04-19 10:30:00', 1, 1, 1);
INSERT INTO `artwork` (`id`, `title`, `price`, `description`, `image`, `for_sale`, `enabled`, `dimension_height`, `dimension_width`, `dimension_length`, `created_at`, `artist_id`, `medium_id`, `theme_id`) VALUES (2, 'test2', 10.99, 'test test', 'image2', 1, 1, 10, 10, 10, '2023-04-19 10:30:00', 2, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `movement`
-- -----------------------------------------------------
START TRANSACTION;
USE `artexicodb`;
INSERT INTO `movement` (`id`, `name`) VALUES (1, 'Contemporary');

COMMIT;


-- -----------------------------------------------------
-- Data for table `material`
-- -----------------------------------------------------
START TRANSACTION;
USE `artexicodb`;
INSERT INTO `material` (`id`, `name`) VALUES (1, 'Oil Paint');

COMMIT;


-- -----------------------------------------------------
-- Data for table `artwork_has_material`
-- -----------------------------------------------------
START TRANSACTION;
USE `artexicodb`;
INSERT INTO `artwork_has_material` (`artwork_id`, `material_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `artwork_has_movement`
-- -----------------------------------------------------
START TRANSACTION;
USE `artexicodb`;
INSERT INTO `artwork_has_movement` (`artwork_id`, `movement_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_has_bookmarked_artwork`
-- -----------------------------------------------------
START TRANSACTION;
USE `artexicodb`;
INSERT INTO `user_has_bookmarked_artwork` (`user_id`, `artwork_id`) VALUES (1, 2);

COMMIT;

