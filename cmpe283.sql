-- -----------------------------------------------------
-- Schema cmpe283
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cmpe283` ;
USE `cmpe283` ;

-- -----------------------------------------------------
-- Table `mobile_sensor`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cmpe283`.`User` (
  `user_id` SMALLINT UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `account` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(45) NOT NULL,
  `role` SMALLINT(10) NULL,
  `cloud_id` SMALLINT(10) UNSIGNED NOT NULL,
  `cloud_cloud_id` TINYINT UNSIGNED NOT NULL,
  `sensor_cloud_sensor_id` INT UNSIGNED NOT NULL,
  `sensor_cloud_cloud_id` TINYINT UNSIGNED NOT NULL,
  `user_sensor_user_id` SMALLINT UNSIGNED NOT NULL,
  `user_sensor_sensor_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
