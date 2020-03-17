
CREATE SCHEMA vegetables_db;
DROP TABLE  IF EXISTS vegetables;
DROP TABLE  IF EXISTS vegetabletype;

CREATE TABLE `vegetables_db`.`vegetables` (
                                              `VegNAme` VARCHAR(64) NOT NULL,
                                              `Calories` DOUBLE NOT NULL,
                                              `Proteins` DOUBLE NOT NULL,
                                              `Fats` DOUBLE NOT NULL,
                                              `Carbohydrates` DOUBLE NOT NULL,
                                              `Type_ID` TINYINT(2) NOT NULL,
                                              PRIMARY KEY (`VegNAme`),
                                              UNIQUE INDEX `VegNAme_UNIQUE` (`VegNAme` ASC) VISIBLE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE TABLE `vegetables_db`.`vegetablestype` (
                                                  `VegType` VARCHAR(24) NOT NULL,
                                                  `Type_ID` TINYINT(2) NOT NULL,
                                                  PRIMARY KEY (`VegType`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Potato', '77', '2.0', '0.4', '16.3', '1');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Cabbage', '25', '1.28', '0.1', '3.3', '1');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Squash', '24', '0.6', '0.3', '4.6', '1');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Broccoli', '34', '2.82', '0.7', '4.04', '1');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Eggplant', '24', '1.2', '0.1', '4.5', '1');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Artichoke', '47', '3.27', '0.15', '5.11', '2');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Watercress', '32', '2.6', '0.7', '4.4', '1');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Corn', '64', '1.95', '0.5', '14.71', '2');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Green onion', '20', '1.3', '0.1', '3.2', '1');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Leek', '36', '2.0', '0.2', '6.3', '1');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Olives', '145', '1.03', '15.32', '0.54', '2');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Carrot', '35', '1.3', '0.1', '6.9', '1');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Cucumber', '11', '0.7', '0.1', '1.9', '1');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Tomato', '18', '0.88', '0.2', '2.69', '1');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Sweet pepper', '27', '1.0', '0.21', '5.42', '2');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Raddish', '16', '0.68', '0.1', '1.8', '1');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Letucce', '16', '1.5', '0.2', '2.0', '1');
INSERT INTO `vegetables_db`.`vegetables` (`VegNAme`, `Calories`, `Proteins`, `Fats`, `Carbohydrates`, `Type_ID`) VALUES ('Beet', '43', '1.61', '0.17', '6.76', '2');

INSERT INTO `vegetables_db`.`vegetablestype` (`VegType`, `Type_ID`) VALUES ('Fresh', '1');
INSERT INTO `vegetables_db`.`vegetablestype` (`VegType`, `Type_ID`) VALUES ('Conserved', '2');
